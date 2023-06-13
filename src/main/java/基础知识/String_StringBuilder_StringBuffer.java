package 基础知识;

public class String_StringBuilder_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " abcdefg ";
		String st2 = new String("abcdefg");
		String st3 = new String("abcdefg");
		System.out.println(s == st2);
		System.out.println(st3 == st2);
		System.out.println(s.equals(st2));
		System.out.println(s.equalsIgnoreCase(st2));
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf('a') + 2);
		System.out.println(s.substring(2));
		System.out.println(s.toLowerCase() + s.toUpperCase());
		System.out.println(s.trim());
		System.out.println(s.replace('c', 'z'));
		System.out.println(s.endsWith("fg "));
		System.out.println(s.startsWith(" ab"));
		String st4 = " abc" + "defg ";
		System.out.println(st4 == s);// 编译器做优化处理

		System.out.println("**************************************");
		StringBuilder s2 = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			s2.append((char) ('a' + i));
		}

		System.out.println(s2);
		System.out.println(s2.charAt(2));
		System.out.println(s2.indexOf("c"));
		System.out.println(s2.substring(2, 3));

		s2.setCharAt(5, '1');
		System.out.println(s2.reverse());
		System.out.println(s2.insert(2, "张三").insert(6, "李四"));
		System.out.println(s2.delete(3, 5));
		testIntern();
	}
	
	static void testIntern () {
		String ss="老婆的操作werer2";
		String s =new String("老婆的操作werer2");
		String s0 =new String("老婆的操作")+"werer2";
		String s1 =s0.intern();
		String s2 =s.intern();
		System.out.println(s1==s2);
		System.out.println(ss==s2);
	}
}
