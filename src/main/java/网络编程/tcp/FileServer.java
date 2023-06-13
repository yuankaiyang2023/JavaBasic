package 网络编程.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	// 请求响应式，请求了才会有回应
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("---------Server----------");
		// 创建服务
		ServerSocket server = new ServerSocket(8888);
		// 阻塞式等待连接
		Socket socket = server.accept();
		InputStream is = new BufferedInputStream(socket.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("D:/my_workspace/MyJavaBasicKnowledge/images/desk_copy.jpg"));
		byte[] bytes = new byte[1024];
		int len = -1;
		while ((len = is.read(bytes)) != -1)
			os.write(bytes, 0, len);
		os.flush();
		os.close();
		is.close();
		socket.close();
		server.close();

	}

}
