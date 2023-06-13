package 网络编程.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSender implements Runnable {
	private DatagramSocket client;
	private BufferedReader reader;
	int port;
	String toIp;
	int toPort;

	public TalkSender(int port, String toIp, int toPort) {
		super();
		this.port = port;
		this.toIp = toIp;
		this.toPort = toPort;
		try {
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			String data;
			try {
				data = reader.readLine();
				byte[] bytes = data.getBytes();
				DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(toIp, toPort));
				client.send(packet);
				if ("bye".equals(data))
					break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
	}

}
