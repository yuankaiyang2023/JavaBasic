package 网络编程;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class URL测试 {

	public static void main(String[] args) throws MalformedURLException, UnknownHostException {
		URL url = new URL("http://www.baidu.com:80/index.html?username=shsxt&age=18#a");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		InetAddress addr = InetAddress.getByName(url.getHost());
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
		System.out.println(url.getRef());
	}

}
