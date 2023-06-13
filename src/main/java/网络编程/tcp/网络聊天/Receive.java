package 网络编程.tcp.网络聊天;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
	Socket client;
	DataInputStream dis;
	boolean isRunning = true;
	
	public Receive(Socket client) {
		super();
		this.client = client;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}

	@Override
	public void run() {
		while (isRunning) {
			System.out.println(receiveMsg());;
		}
	}

	private String receiveMsg() {
		try {
			return dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
		return null;
	}

}
