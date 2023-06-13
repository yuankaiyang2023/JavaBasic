package 基础知识;

public class 递归 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		long rel = factorial(6);
		long t2 = System.currentTimeMillis();
		System.out.println(rel);
		System.out.println(t1);
		System.out.println(t2);
	}

	public static long factorial(long n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}
}
