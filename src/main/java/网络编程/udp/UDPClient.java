package 网络编程.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		System.out.println("sending...");
		DatagramSocket ds = new DatagramSocket(8888);
		String str = "今天天气不错...";
		byte[] bytes = str.getBytes();
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("localhost", 9999));
		ds.send(dp);
		ds.close();
	}

}
