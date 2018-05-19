package com.zxy_01;

import java.io.BufferedWriter;
import java.net.Socket;

public class MsgSendThread implements Runnable {

	private Socket s;
	// private BufferedWriter bw;

	public MsgSendThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		// try {
		// OutputStream os = s.getOutputStream();
		// this.bw = new BufferedWriter(new OutputStreamWriter(os));
		//
		// while(true) {
		//
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

}
