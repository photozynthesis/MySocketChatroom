package com.zxy.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MsgReceiveThread implements Runnable {

	private ChatServer server;
	
	private String address;
	private BufferedReader br;

	public MsgReceiveThread(ChatServer server, Socket s) {

		this.server = server;
		this.address = s.getInetAddress().getHostAddress();
		try {
			this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		
		String input;
		try {
			while ((input = br.readLine()) != null) {
				if (input.equals("88")) {
					this.server.msg(address + ": " + input);
					this.server.msg("[System]: " + address + "已断开连接");
					break;
				}
				this.server.msg(address + ": " + input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
