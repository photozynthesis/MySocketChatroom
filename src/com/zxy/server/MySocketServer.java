package com.zxy.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Enumeration;

public abstract class MySocketServer {

	/**
	 * 不管是聊天服务器还是文件传输服务器，都有一个服务端，一个本地ip地址和一个端口
	 */
	public ServerSocket ss;
	public InetAddress localAddress;
	public int port;

	/**
	 * 通过指定端口来构造抽象服务器
	 * 
	 * @param port
	 * @throws IOException
	 */
	public MySocketServer(int port) throws IOException {
		this.port = port;
		this.ss = new ServerSocket(port);
		Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		while (en.hasMoreElements()) {
			NetworkInterface netInterface = (NetworkInterface) en.nextElement();
			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				InetAddress address = addresses.nextElement();
				String ip = address.getHostAddress();
				if (ip.startsWith("192.168.1.")) {
					this.localAddress = address;
					return;
				}
				// System.out.println(address.getHostAddress());
			}
		}
		// this.localAddress = InetAddress.getLocalHost();
	}

	/**
	 * 获取抽象服务器的ip地址
	 * 
	 * @return 服务器所在机器的ip地址
	 */
	public String getLocalAddress() {
		return localAddress.getHostAddress();
	}

	/**
	 * 通过字符串设置抽象服务器的ip地址
	 * 
	 * @param ip
	 * @throws UnknownHostException
	 */
	public void setLocalAddress(String ip) throws UnknownHostException {
		this.localAddress = InetAddress.getByName(ip);
	}

	/**
	 * 开启抽象服务器
	 */
	public abstract void startServer();

	/**
	 * 关闭抽象服务器
	 */
	public abstract void shutDown();

}
