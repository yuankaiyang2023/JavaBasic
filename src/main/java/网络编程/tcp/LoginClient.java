package 网络编程.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-------client--------");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Socket client = new Socket("localhost", 8888);
		System.out.println("请输入用户名:");
		String username = reader.readLine();
		System.out.println("请输入密码:");
		String userpwd = reader.readLine();
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("username=" + username + "&" + "userpwd=" + userpwd);
		dos.flush();
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		System.out.println(str);
		
		dos.close();
		client.close();
		reader.close();
	}

}
