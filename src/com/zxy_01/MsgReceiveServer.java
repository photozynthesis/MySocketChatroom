package com.zxy_01;

import java.io.IOException;
import java.net.Socket;

public class MsgReceiveServer extends MySocketServer {

	/**
	 * 通过port构造ServerSocket对象，启动服务端 仅供本类内部使用
	 * 
	 * @param port
	 * @throws IOException
	 */
	private MsgReceiveServer(int port) throws IOException {
		super(port);
	}

	/**
	 * 外部通过此方法启动服务端
	 * 
	 * @throws IOException
	 */
	public void startServer() {
		// while (true) {
		// try {
		// Socket s = ss.accept();
		// new Thread(new MsgUserThread(s)).start();
		// } catch (IOException e) {
		// System.out.println("服务器记录到一次失败的连接");
		// e.printStackTrace();
		// }
		// }
		while(true) {
			try {
				Socket s = ss.accept();
				User u = new User(s);
				u.connect();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	// public void acceptSocket() throws IOException {
	// this.s = this.ss.accept();
	// this.is = this.s.getInputStream();
	// System.out.println("成功建立来自" + this.s.getInetAddress().getHostAddress() +
	// "的连接");
	// }
	//
	// public void getMessage() throws IOException {
	// BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
	// String output;
	// while ((output = br.readLine()) != null) {
	// if (output.equals("再见")) {
	// System.out.println("--- 会话已结束 ---");
	// break;
	// }
	// System.out.println(this.s.getInetAddress().getHostAddress() + ":" + output);
	// }
	// this.s.close();
	// }

	/**
	 * 外部通过此方法关闭服务端
	 */
	@Override
	public void shutDown() {
		try {
			this.ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
