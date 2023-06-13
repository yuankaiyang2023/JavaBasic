package 网络编程.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceiver implements Runnable {
	private DatagramSocket server;
	int port;
	String from;
	public TalkReceiver(int port, String from) {
		super();
		try {
			this.from = from;
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			byte[] container = new byte[1024 * 60];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			try {
				server.receive(packet);// 阻塞式接收
				byte[] data = packet.getData();
				String result = new String(data, 0, data.length);
				System.out.println(from + ":" + result);
				if ("bye".equals(result)) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		server.close();
	}

}
