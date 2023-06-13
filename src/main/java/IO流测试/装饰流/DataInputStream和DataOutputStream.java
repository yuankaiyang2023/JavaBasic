package IO流测试.装饰流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStream和DataOutputStream {
	public static void main(String[] args) {
		copyDataToArrayThenReadFromArray();
		copyDataToFileThenReadFromFile("src/IO流测试/ioTestDataOutputStream");
	}

	public static void copyDataToArrayThenReadFromArray() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));// 双重装饰baos，扩展功能,核心功能仍然是节点流，装饰器将基本数据转化为字节数组并缓存
		try {
			dos.writeUTF("测试DataInputSteam: ");
			dos.writeInt(1);
			dos.writeBoolean(true);
			dos.flush();
			byte[] bytes = baos.toByteArray();
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(bytes)));
			String msg = dis.readUTF();
			int a = dis.readInt();
			boolean b = dis.readBoolean();
			System.out.println(msg);
			System.out.println(a);
			System.out.println(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void copyDataToFileThenReadFromFile(String str) {
		FileOutputStream baos;
		try {
			baos = new FileOutputStream(str);
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));// 双重装饰baos，扩展功能,核心功能仍然是节点流，装饰器将基本数据转化为字节数组并缓存
			dos.writeUTF("测试DataInputSteam: ");
			dos.writeInt(1);
			dos.writeBoolean(true);
			dos.flush();
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(str)));
			String msg = dis.readUTF();
			int a = dis.readInt();
			boolean b = dis.readBoolean();
			System.out.println(msg);
			System.out.println(a);
			System.out.println(b);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
