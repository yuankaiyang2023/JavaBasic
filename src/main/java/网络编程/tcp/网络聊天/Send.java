package 网络编程.tcp.网络聊天;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {
	Socket client;
	String name;
	Boolean isRunning = true;
	DataOutputStream dos;
	BufferedReader reader;

	public Send(Socket client, String name) {
		super();
		reader = new BufferedReader(new InputStreamReader(System.in));
		this.client = client;
		this.name = name;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			sendMsg(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos, reader);
		}
	}

	@Override
	public void run() {
		while (isRunning) {
			try {
				String msg = reader.readLine();
				sendMsg(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning = false;
				CloseUtil.closeAll(dos, reader);
			}

		}

	}

	private void sendMsg(String msg) {
		try {
			if (null != msg && !"".equals(msg))
				dos.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos, reader);
		}
	}

}
