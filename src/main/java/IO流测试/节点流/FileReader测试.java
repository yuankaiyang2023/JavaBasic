package IO流测试.节点流;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

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
public class FileReader测试 {

	public static void main(String[] args) {
		// File file = new File("src/IO流测试/ioTest");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src/IO流测试/ioTest"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
