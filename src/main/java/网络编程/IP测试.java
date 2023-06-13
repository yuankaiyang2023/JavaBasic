package 网络编程;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class IP测试 {

	public static void main(String[] args) throws UnknownHostException {
		// ip地址
		InetAddress addr = InetAddress.getLocalHost();
		// addr =InetAddress.getByName("www.shsxt.com");
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());

		// 包含端口的IP地址
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 7080);
		// InetSocketAddress isa2 = new InetSocketAddress("localhost",6080);
		// InetSocketAddress isa3 = new InetSocketAddress("www.baidu.com",680);
		System.out.println(isa.getHostName());
		System.out.println(isa.getAddress());
		System.out.println(isa.getPort());
		// 端口号由4个十六进制数组组成
		int s = (int) Math.pow(16, 4);
		System.out.println(s);
		System.out.println(0xffff);// 端口号范围：0-0xffff(0-65535)
	}

}
