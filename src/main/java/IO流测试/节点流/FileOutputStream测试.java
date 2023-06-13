package IO流测试.节点流;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author Administrator
 *
 */
public class FileOutputStream测试 {

	public static void main(String[] args) {
		File file = new File("src/IO流测试/ioTest");
		OutputStream op = null;
		try {
			op = new BufferedOutputStream(new FileOutputStream(file, true));//true追加， false覆盖
			String str = "today is Sunday";
			byte[] bytes=str.getBytes(); //最简洁写法
//			byte[] bytes = new byte[100];
//			bytes = str.getBytes();// bytes 更改了指向对象，长度发生变化
//			for(int i=0;i<str.getBytes().length;i++) {//bytes指向原对象，bytes[i]指向的值或者引用的对象地址会变
//				bytes[i] =str.getBytes()[i];  
//			}
			op.write(bytes, 0, bytes.length);
			op.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != op) {
				try {
					op.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
