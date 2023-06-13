package IO流测试.节点流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_Copy_FilWriter {

	public static void main(String[] args) {
		// copyTxt("src/IO流测试/ioTest", "src/IO流测试/ioTest2");
		File src = new File("src/IO流测试/ioTest");
		File dest = new File("src/IO流测试/ioTest2");
		// copyTxt(src, dest);
		copyTxt("src/IO流测试/ioTest", "src/IO流测试/ioTest200");
	}

//	public static void copyTxt(File src, File dest) {
//		try (BufferedReader reader = new BufferedReader(new FileReader(src));
//				BufferedWriter writer = new BufferedWriter(new FileWriter(dest));) {
//			String line = null;
//			while ((line = reader.readLine()) != null) {
//				writer.append(line);
//				writer.newLine();
//			}
//			writer.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public static void copyTxt(String src, String dest) {
		try (BufferedReader reader = new BufferedReader(new FileReader(src));
				BufferedWriter writer = new BufferedWriter(new FileWriter(dest));) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.append(line);
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
