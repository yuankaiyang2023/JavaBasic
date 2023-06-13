package IO流测试.CommonsIO;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class FileUtils测试 {

	public static void main(String[] args) throws IOException {
		//文件大小
		long len = FileUtils
				.sizeOf(new File("D:\\my_workspace\\MyJavaBasicKnowledge\\src\\IO流测试\\CommonsIO\\CommonsIO测试.java"));
		long len2 = FileUtils.sizeOf(new File("D:\\my_workspace\\MyJavaBasicKnowledge"));
		long len3 = FileUtils.sizeOfDirectory(new File("D:\\my_workspace\\MyJavaBasicKnowledge"));
		System.out.println(len);
		System.out.println(len2);
		System.out.println(len3);
		
		//文件列表过滤
		Collection<File> fileList2 = FileUtils.listFiles(new File("D:\\my_workspace\\MyJavaBasicKnowledge"),
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		for (File file : fileList2) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("*******************************");
		Collection<File> fileList3 = FileUtils.listFiles(new File("D:\\my_workspace\\MyJavaBasicKnowledge"),
				new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
		for (File file : fileList3) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("*******************************");
		Collection<File> fileList4 = FileUtils.listFiles(new File("D:\\my_workspace\\MyJavaBasicKnowledge"),
				new SuffixFileFilter("java").or(new SuffixFileFilter("class")).and(EmptyFileFilter.NOT_EMPTY),
				DirectoryFileFilter.INSTANCE);
		for (File file : fileList4) {
			System.out.println(file.getAbsolutePath());
		}
		
		//文件读取
		File commonIOsFile =new File("D:\\my_workspace\\MyJavaBasicKnowledge\\src\\IO流测试\\CommonsIO\\commonIOsFile.txt");
		String msg = FileUtils.readFileToString(commonIOsFile,"gbk" );
		byte[] bytes = FileUtils.readFileToByteArray(commonIOsFile);
		System.out.println(msg+bytes);
		List<String> msgs = FileUtils.readLines(commonIOsFile,"gbk");
		for(String str : msgs) {
			System.out.println(str);
		}
		LineIterator ite =FileUtils.lineIterator(commonIOsFile,"gbk");
		while(ite.hasNext()) {
			System.out.println(ite.nextLine());
		}
		
		//文件写出
		FileUtils.write(commonIOsFile,"我是快乐的小乌鸦\r\n","gbk");
		FileUtils.writeStringToFile(commonIOsFile,"我很快乐\r\n","gbk",true);//write可设置追加内容：true
		FileUtils.writeByteArrayToFile(commonIOsFile, "ddd你是谁\r\n".getBytes("gbk"),true);
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("张三3");
		list.add("张三4");
		FileUtils.writeLines(commonIOsFile, list, "\r\n");
		
		//文件copy(先读后写)
		FileUtils.copyFile(commonIOsFile, new File("D:/my_workspace/MyJavaBasicKnowledge/src/IO流测试/CommonsIO/commonIOsFile_copy.txt"));
		FileUtils.copyFileToDirectory(commonIOsFile, new File("D:/my_workspace/MyJavaBasicKnowledge/src/IO流测试"));
		//FileUtils.copyDirectory(srcDir, destDir);
		//FileUtils.copyDirectory(srcDir, destDir, preserveFileDate);//保留内容
		//FileUtils.copyDirectoryToDirectory(sourceDir, destinationDir);
		//String url= "";
		//图片下载
		FileUtils.copyURLToFile(new URL("xxxx.jpg"), new File("D:/my_workspace/MyJavaBasicKnowledge/src/IO流测试/test.jpg"));
	}

}
