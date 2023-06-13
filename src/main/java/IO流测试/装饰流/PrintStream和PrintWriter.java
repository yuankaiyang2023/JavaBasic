package IO流测试.装饰流;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStream和PrintWriter {
//2个输出流
	public static void main(String[] args) {
		PrintStream ps = System.out;
		ps.println(222);
		ps.println(true);
		try {
			ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("src/IO流测试/testPrintStream")),true);//true 刷新
			ps.println("打印流");
			ps.println(true);
			System.setOut(ps);//不能触发全局效果，?????????????
			System.out.println("change");
//			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
//			System.out.println("I am backing");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}

}
