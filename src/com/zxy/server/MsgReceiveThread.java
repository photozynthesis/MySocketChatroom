package com.zxy.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MsgReceiveThread implements Runnable {

	private ChatServer server;
	
	private User user;
	
	private String address;
	private BufferedReader br;

	public MsgReceiveThread(ChatServer server, User user, Socket s) {

		this.server = server;
		this.user = user;
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
				this.server.msg(address + ": " + input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.user.disconnect();
		
	}

}
