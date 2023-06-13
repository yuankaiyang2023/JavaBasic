package 网络编程.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-------client--------");
		Socket client = new Socket("localhost", 8888);
		InputStream is = new BufferedInputStream(new FileInputStream(new File("D:\\my_workspace\\MyJavaBasicKnowledge\\images\\desk.jpg")));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] bytes = new byte[1024];
		int len = -1;
		while ((len = is.read(bytes)) != -1)
			os.write(bytes, 0, len);
		os.flush();
		os.close();
		is.close();
		client.close();
	}

}
