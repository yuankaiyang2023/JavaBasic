package IO流测试.节点流;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节输入流
 * 
 * 1。创建源
 * 
 * 2。 选择流
 * 
 * 3. 操作
 * 
 * 4. 释放资源
 * 
 * @author Yuankai Yang
 *
 */
public class FileInputStream测试 {

	public static void main(String[] args) {
		File file = new File("src/IO流测试/ioTest");
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));

//			int temp;
//			while ((temp = inputStream.read()) != -1) {
//				System.out.println((char) temp);
//			}

//			for (int temp = inputStream.read(); temp > -1; temp = inputStream.read()) {
//				System.out.println(":" + (char) temp);
//			}

			int len = -1;
			byte[] bytes = new byte[3];
			while ((len = inputStream.read(bytes)) != -1) {
				String str = new String(bytes, 0, len);
				System.out.println(str);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
