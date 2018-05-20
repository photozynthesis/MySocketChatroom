package com.zxy.client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	
	public boolean flag = false;
	
	private int port;
	private Socket socket;
	private DatagramSocket ds;
	private Thread sendThread;
	private Thread receiveThread;
	
	public ChatClient(String ip, int port) {
		
		try {
			this.socket = new Socket(ip, port);
			this.ds = new DatagramSocket(port);
		} catch (UnknownHostException e) {
			System.out.println("您输入的IP地址有误/无法连接到服务器！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("与服务端建立连接时出了一些问题！");
			e.printStackTrace();
		}
		this.sendThread = new Thread(new MsgSendThread(this, this.socket));
		this.receiveThread = new Thread(new MsgReceiveThread(this, this.ds));
		
	}
	
	public void startClient() {
		
		this.flag = true;
		this.receiveThread.start();
		this.sendThread.start();
		System.out.println("成功连接到服务器，输入内容以开始聊天！输入88将退出聊天。");
		
	}
	
	public void closeClient() {
		
		this.flag = false;
		this.receiveThread.interrupt();
		// this.ds.close();
		this.sendThread.interrupt();
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("您已与服务器断开连接！");
		
	}
	
}
