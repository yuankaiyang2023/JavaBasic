package 网络编程.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
	// 请求响应式，请求了才会有回应
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("---------Server----------");
		// 创建服务
		ServerSocket server = new ServerSocket(8888);
		// 阻塞式等待连接
		Socket socket = server.accept();
		System.out.println("---------建立了连接----------");
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		System.out.println("---------产生流----------");
		String str = dis.readUTF();
		System.out.println("---------接收了数据----------");
		String[] array = str.split("&");
		String userName = "";
		String userPwd = "";
		for (String s : array) {
			String[] userInfo = s.split("=");
			if ("username".equals(userInfo[0])) {
				userName = userInfo[1];
				System.out.println("你的用户名：" + userInfo[1]);
			} else if ("userpwd".equals(userInfo[0])) {
				userPwd = userInfo[1];
				System.out.println("你的密码 ：" + userInfo[1]);
			}
		}
		Thread.sleep(1000);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		if ("username".equals(userName) && "userpwd".equals(userPwd))
			dos.writeUTF("登录成功");
		else
			dos.writeUTF("登录失败");
		dos.flush();
		dos.close();
		dis.close();
		socket.close();
		server.close();

	}

}
