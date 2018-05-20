/*
 * 运行服务端的主类
 */
package com.zxy.server;

import java.io.IOException;
import java.util.Scanner;

public class ServerLauncher {
	public static void main(String[] args) throws IOException {
		
		System.out.println("--- MySocketServer ---");
		System.out.println("请输入数字：1.启动聊天服务器；2.启动文件传输服务器。");
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		switch (mode) {
		case 1:
			System.out.println("请输入聊天服务器的端口(0~65535)：");
			int port = sc.nextInt();
			System.out.println("正在启动聊天服务器...");
			ChatServer server = new ChatServer(port);
			System.out.println("聊天服务器已在地址" + server.getLocalAddress() + "端口" + port + "上启动，正在等待客户端的连接...");
			server.startServer();
			
		// case 2:
		}

	}
}
