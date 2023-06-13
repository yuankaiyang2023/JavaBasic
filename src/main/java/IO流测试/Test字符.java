package IO流测试;

import java.io.UnsupportedEncodingException;

public class Test字符 {
	//gbk:字母1个字符，中文2个字符      utf-8 字母1个字节，中文3个字节    utf-16 字母，中文2个字节     asc码都是1个字节   iso-8859-1都是一个字节
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "我爱中国a";//gbk编码
		byte[] bt = s.getBytes();//还原成字节
		System.out.println(bt.length + "  " + bt);
		byte[] bt2 = s.getBytes("utf-8");//还原成指定字符集的字节
		System.out.println(bt2.length + "  " + bt2);
		byte[] bt3 = s.getBytes("UTF-16LE");
		System.out.println(bt3.length + "  " + bt3);
		byte[] bt4 = s.getBytes("US-ASCII"); 
		System.out.println(bt4.length + "  " + bt4);
		byte[] bt5 = s.getBytes("iso-8859-1"); 
		System.out.println(bt5.length + "  " + bt5);
		
		String str = new String(bt2,"utf8");//解码
		System.out.println(str);
		System.out.println(isEncoding(str, "utf8"));
	}
	
	public static boolean isEncoding(String str,String encode) throws UnsupportedEncodingException {
		String tem =new String(str.getBytes(encode),encode);
		if(str.equals(tem))
			return true;
		
		return false;
	}
}
