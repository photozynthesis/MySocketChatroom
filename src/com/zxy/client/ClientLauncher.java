/*
 * 运行客户端的主类
 */
package com.zxy.client;

import java.util.Scanner;

public class ClientLauncher {
	public static void main(String[] args) {
		
		System.out.println("--- MySocketClient ---");
		System.out.println("请输入数字：1.启动聊天客户端；2.启动文件传输客户端。");
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		switch (mode) {
		case 1:
			System.out.println("请输入聊天服务器的IP地址：");
			String ip = sc.next();
			System.out.println("请输入聊天服务器的端口(0~65535)：");
			int port = sc.nextInt();
			System.out.println("正在连接到聊天服务器...");
			ChatClient client = new ChatClient(ip, port);
			client.startClient();
			// ChatServer server = new ChatServer(port);
			
			// server.startServer();
			
		// case 2:
		}
	}
}
