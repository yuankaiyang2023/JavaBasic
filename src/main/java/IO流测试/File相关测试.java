package IO流测试;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class File相关测试 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		File f = new File("D:/my_workspace/book.txt");
		f.createNewFile();
		f.renameTo(new File("D:/my_workspace/book2.txt"));
		File f2 = new File("D:\\my_workspace\\book3.txt");
		f2.createNewFile();
		System.out.println(f);
		System.out.println(f2);
		f2.delete();
		File f3 = new File("book4.txt");
		f3.createNewFile();
		System.out.println(f3.exists());
		System.out.println(f3.isDirectory());
		System.out.println(f3.isFile());
		System.out.println((new Date(f3.lastModified())));
		System.out.println(f3.length());
		System.out.println(f3.getName());
		System.out.println(f3.getParent());
		System.out.println(f3.getPath());
		System.out.println(f3.getAbsolutePath());
		File f4 = new File("D:/my_workspace/testfile");
		f4.mkdir();
		File f5 = new File("D:/my_workspace/testfiles/t/s");
		f5.mkdirs();
		File f6 = new File("D:/my_workspace/testfiles2/t2/s2/book.txt");
		System.out.println(f6.getParentFile().mkdirs());
		f6.createNewFile();
		System.out.println("*********************************");
		
		
		//遍历目录结构
		printFile(new File("D:\\BaiduNetdiskDownload"),0);
		//列出所有盘符
		testListRoots(f);
		
	}
	
	static void printFile(File file,int level) {
		for(int i =0;i<level;i++) {
			System.out.print("/");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files =file.listFiles();
			for(File temp:files) {
				printFile(temp,level+1);
			}
		}
	}
	static void testListRoots(File file) {
		File[] files =file.listRoots();
		for(File f2 : files) {
			System.out.println(f2.getAbsolutePath());
		}
	}
}
