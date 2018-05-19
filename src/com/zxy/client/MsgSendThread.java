package com.zxy.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MsgSendThread implements Runnable {

	private Socket socket;
	private BufferedWriter bw;
	private BufferedReader br;
	
	public MsgSendThread(Socket socket) {
		this.socket = socket;
		try {
			this.bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			this.br = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			System.out.println("客户端出了问题，错误代码：buffer");
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String str;
		while(true) {
			try {
				str = br.readLine();
				bw.write(str);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
