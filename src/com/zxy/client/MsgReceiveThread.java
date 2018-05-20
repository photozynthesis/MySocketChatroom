package com.zxy.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MsgReceiveThread implements Runnable {

	private ChatClient client;
	
	private DatagramSocket ds;
	private DatagramPacket packet;

	public MsgReceiveThread(ChatClient client, DatagramSocket ds) {
		this.client = client;
		this.ds = ds;
		this.packet = new DatagramPacket(new byte[1024], 1024);
	}

	@Override
	public void run() {
		String str;
		while (true) {
			if(!this.client.flag) {
				this.ds.close();
				break;
			}
			try {
				this.ds.receive(packet);
				int len = packet.getLength();
				str = new String(packet.getData(), 0, len);
				System.out.println(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
