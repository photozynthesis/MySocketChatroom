package com.zxy_01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class MySocketServer {
	
	ServerSocket ss;
	InetAddress address;
	Socket s;
	
	public MySocketServer(int port) throws IOException {
		this.ss = new ServerSocket(port);
	}

	public String getAddress() {
		return address.getHostAddress();
	}

	public void setAddress(String ip) throws UnknownHostException {
		this.address = InetAddress.getByName(ip);
	}

	public Socket getSocket() {
		return s;
	}

	public void setSocket(Socket s) {
		this.s = s;
	}
	
}
