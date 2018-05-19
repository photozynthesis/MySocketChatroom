package com.zxy_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MsgReceiveThread implements Runnable {

	// private Socket s;
	private String address;
	private BufferedReader br;

	public MsgReceiveThread(Socket s) {
		// this.s = s;
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
					System.out.println(address + ": " + input);
					break;
				}
				System.out.println(address + ": " + input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
