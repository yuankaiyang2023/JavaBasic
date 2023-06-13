package IO流测试.节点流;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author Administrator
 *
 */
public class FileWriter测试 {
 
	public static void main(String[] args) {
		File file = new File("src/IO流测试/dest.txt");
		BufferedWriter op = null;
		try {
			op =new BufferedWriter(new FileWriter(file, true)) ;
			op.append("today is Sunday");
			op.newLine();
			op.append("today is Sunday2");
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
