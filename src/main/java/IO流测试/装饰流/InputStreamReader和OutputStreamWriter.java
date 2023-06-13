package IO流测试.装饰流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

//装饰流：BufferedReader InputStreamReader
//InputStreamReader 字符流处理字节流(转换流)
public class InputStreamReader和OutputStreamWriter {
	public static void main(String[] args) {
//		网络爬虫原理：获取字节流转为字符流
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new URL("http://www.baidu.com").openStream(), "utf-8")); //
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("baidu.html"), "utf-8"));) {
			// new OutputStreamWriter(new FileOutputStream("baidu.txt"),"gbk"));) {
			// new OutputStreamWriter(new FileOutputStream("baidu.java"),"gbk"));) {
			String msg;
			while ((msg = reader.readLine()) != null) {
				writer.append(msg);
				writer.newLine();
			}
			writer.flush();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		控制台输入输出();
	}
	
	public static void 控制台输入输出() {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in)); 
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(System.out))) {
			String msg ="";
			while(!msg.equals("exit")) {
				msg = reader.readLine();
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
