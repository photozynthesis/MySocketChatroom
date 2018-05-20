/*
 * 聊天服务器
 */
package com.zxy.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatServer extends MySocketServer {

	private DatagramSocket ds;
	private InetAddress broadcastIp;

	/**
	 * 通过port构造ServerSocket对象，启动服务端 仅供本类内部使用
	 * 
	 * @param port
	 * @throws IOException
	 */
	public ChatServer(int port) throws IOException {
		super(port);
	}

	/**
	 * 外部通过此方法启动服务端
	 * 
	 * @throws IOException
	 */
	public void startServer() {

		try {
			this.ds = new DatagramSocket();
			this.broadcastIp = InetAddress.getByName("192.168.1.255");
		} catch (UnknownHostException e1) {
			System.out.println("广播地址设置失败");
			e1.printStackTrace();
		} catch (SocketException e2) {
			e2.printStackTrace();
		}

		while (true) {
			try {
				Socket s = ss.accept();
				User u = new User(this, s);
				u.connect();
			} catch (IOException e3) {
				System.out.println("[server]: 服务器记录到一次失败的连接");
				e3.printStackTrace();
			}
		}
		
	}

	/**
	 * 接收要显示在服务端控制台的消息，显示消息在服务端控制台，并UDP广播
	 * 
	 * @param s
	 */
	public void msg(String s) {

		System.out.println(s);
		byte[] bys = s.getBytes();
		DatagramPacket packet = new DatagramPacket(bys, bys.length, broadcastIp, this.port);
		try {
			this.ds.send(packet);
		} catch (IOException e) {
			System.out.println("广播消息失败");
			e.printStackTrace();
		}

	}

	/**
	 * 外部通过此方法关闭服务端
	 */
	@Override
	public void shutDown() {

		try {
			this.ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
