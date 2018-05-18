package com.zxy_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageReceiveServer extends MySocketServer {

	private InputStream is;

	public MessageReceiveServer(int port) throws IOException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public void acceptSocket() throws IOException {
		this.s = this.ss.accept();
		this.is = this.s.getInputStream();
		System.out.println("成功建立来自" + this.s.getInetAddress().getHostAddress() + "的连接");
	}

	public void getMessage() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
		String output;
		while ((output = br.readLine()) != null) {
			if (output.equals("再见")) {
				System.out.println("--- 会话已结束 ---");
				break;
			}
			System.out.println(this.s.getInetAddress().getHostAddress() + ":" + output);
		}
		this.s.close();
	}
}
