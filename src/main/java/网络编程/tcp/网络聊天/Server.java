package 网络编程.tcp.网络聊天;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
	CopyOnWriteArrayList<MyChannel> channels = new CopyOnWriteArrayList<MyChannel>();

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		ServerSocket serverSocket = new ServerSocket(8888);
		while (true) {
			Socket client = serverSocket.accept();
			MyChannel channel = server.new MyChannel(client);
			server.channels.add(channel);
			new Thread(channel).start();
		}
	}

	class MyChannel implements Runnable {
		private boolean isRunning = true;
		Socket client;
		DataInputStream dis;
		DataOutputStream dos;
		private String name;

		public MyChannel(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				name = dis.readUTF();
				this.sendMsg("欢迎您进入聊天室");
				this.sendMsgToOthers(name, true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CloseUtil.closeAll(dos, dis);
				isRunning = false;
			}
		}

		@Override
		public void run() {
			String msg;
			while (isRunning) {
				msg = reveiveMsg();
				sendMsgToOthers(msg, false);
			}
		}

		private void sendMsgToOthers(String msg, boolean sys) {

			if (msg.startsWith("@") && msg.indexOf(":") > -1) {
				String name = msg.substring(1, msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":")+1);
				for (MyChannel other : channels) {
					if (other.name.equals(name))
						other.sendMsg(this.name + "悄悄对你说：" + content);
					
				}
			} else {
				for (MyChannel other : channels) {
					if (other == this)
						continue;
					if (sys == false)
						other.sendMsg(name + "对所有人说：" + msg);
					else
						other.sendMsg("系统消息：" + msg + "进入了聊天室");
				}
			}

		}

		private void sendMsg(String s) {
			try {
				dos.writeUTF(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CloseUtil.closeAll(dos);
				isRunning = false;
			}
		}

		private String reveiveMsg() {
			try {
				String msg = dis.readUTF();
				return msg;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning = false;
			}
			return null;
		}

	}
}
