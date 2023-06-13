package 基础知识;

import java.util.Arrays;

public class Integer包装类测试 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 基本类型转为包装类
		Integer a = new Integer(3);
		Integer b = Integer.valueOf(30);
		// 包装类转为基本类型
		int c = b.intValue();
		double d = b.doubleValue();
		// String转为包装类
		Integer e = new Integer("222");
		Integer f = Integer.parseInt("9999");
		// 包装类转为String
		String s = f.toString();
		// 包装类常量
		System.out.println(Integer.BYTES);// 4个字符
		System.out.println(Integer.SIZE);// 32位
		System.out.println(Integer.MAX_VALUE);
		Integer i = 111; //Integer.valueOf(111)
		Integer i2 = 111;
		System.out.println(i == i2);//默认缓存-128到127之间的Integer对象
	}

}
