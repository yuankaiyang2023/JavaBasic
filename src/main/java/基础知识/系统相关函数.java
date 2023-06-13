package 基础知识;

public class 系统相关函数 {
	public static void main(String[] args) {
		// 系统内存
		long num = Runtime.getRuntime().freeMemory();
		long num2 = Runtime.getRuntime().maxMemory();
		long num3 = Runtime.getRuntime().totalMemory();
		//当前毫秒数
		long time = System.currentTimeMillis();
		System.out.println(num/1024.0/1024);
		System.out.println(num2/1024.0/1024);
		System.out.println(num3/1024.0/1024);
		System.out.println(time);
		//用户根目录
		System.out.println(System.getProperty("user.dir"));
		//java中所有equals象，hashCode相同
		String s ="abc";
		String s2= new String("abc");
		String s3= new String("abc");
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(221&15);
		System.out.println(221%16);

	}
}
