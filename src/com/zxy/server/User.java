/**
 * 用户类，每个用户包含一个Socket和两个线程。
 * 两个线程分别负责从客户端接收数据和向客户端发送数据。
 */
package com.zxy.server;

import java.net.Socket;

public class User {
	
	private ChatServer server;
	
	private Socket s;
	private Thread receive;
	private String ip;
	
	public User(ChatServer server, Socket s) {
		this.server = server;
		this.s = s;
		this.receive = new Thread(new MsgReceiveThread(server, this.s));
		this.ip = this.s.getInetAddress().getHostAddress();
	}
	
	public void connect() {
		this.receive.start();
		this.server.msg("[System]: " + ip + "加入了聊天室！");
	}
}
