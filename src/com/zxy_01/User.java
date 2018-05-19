/**
 * 用户类，每个用户包含一个Socket和两个线程。
 * 两个线程分别负责从客户端接收数据和向客户端发送数据。
 */
package com.zxy_01;

import java.net.Socket;

public class User {
	
	private Socket s;
	private Thread send;
	private Thread receive;
	private String ip;
	
	public User(Socket s) {
		this.s = s;
		this.send = new Thread(new MsgSendThread(this.s));
		this.receive = new Thread(new MsgReceiveThread(this.s));
		this.ip = this.s.getInetAddress().getHostAddress();
	}
	
	public void connect() {
		this.receive.start();
		this.send.start();
		System.out.println("系统消息: " + ip + "加入了聊天室！");
	}
}
