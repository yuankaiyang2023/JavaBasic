package 网络编程.tcp.网络聊天;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client =new Socket("localhost",8888);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入姓名");
		String name =reader.readLine();
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}

}
