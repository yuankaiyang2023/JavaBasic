package IO流测试;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class File相关测试2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		
		System.out.println(File.pathSeparator);//给环境变量path用的
		System.out.println(File.pathSeparatorChar);
		System.out.println(System.getProperty("user.dir"));
		 
		File f = new File("D:/myworkspace/docs");
		File f3 = new File("D:/myworkspace/","docs");
		File f4 = new File(new File("D:/myworkspace"),"docs/pkg");
		System.out.println(f4.getPath());
		System.out.println(f4.getAbsolutePath());
		System.out.println(f4.getName());
		System.out.println(f4.getParent());
		System.out.println(f4.getParentFile().getName());

		System.out.println("********************************");
		URI u = f.toURI();
		System.out.println(u);
		File f2 = new File("abc.png");//项目根目录 user.dir
		File f5 = new File("/myworkspacetest/docs5");//磁盘根目录
		System.out.println(f2.exists());
		System.out.println(f2.getAbsolutePath());
		System.out.println(f5.getAbsolutePath());
		System.out.println(f2.isFile());
		System.out.println(f2.isDirectory());
		try {
			f2.createNewFile();
			System.out.println(f2.length());
			f2.delete();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		//con,com3,com4等为操作系统所有，不可创建
	}

}
