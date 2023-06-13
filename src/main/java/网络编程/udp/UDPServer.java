package 网络编程.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		System.out.println("receiving...");
		DatagramSocket ds = new DatagramSocket(9999);
		byte[] bytes = new byte[1024 * 60];
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
		ds.receive(dp);
		String str = new String(dp.getData());
		System.out.println(str);
	}

}
