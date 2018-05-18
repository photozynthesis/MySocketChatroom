/*
 * 运行服务端的主类
 */
package com.zxy_01;

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
				System.out.println("正在启动聊天Socket服务器...");
				MessageReceiveServer mrs = new MessageReceiveServer(12345);
				System.out.println("成功启动聊天服务器，正在等待客户端的连接...");
				mrs.acceptSocket();
				mrs.getMessage();
		//	case 2:
		}

	}
}
