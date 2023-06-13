package 多线程测试;

public class Lambda测试 {

	public static void main(String[] args) {
		LambdaInterface l = () -> {//无参数
			System.out.println("*****" + Thread.currentThread().getName());

		};
		l.test();
		Lambda测试.testLambda3(() -> {
			System.out.println("*****" + Thread.currentThread().getName());
		});
		System.out.println("**************");
		LambdaInterface2 l2 = (a, b) -> {//有参数
			return a + b;
		};
		l2.add(19, 11);

		testLambda4((a, b) -> {
			return a + b;
		});

		l2 = (a, b) -> a + b;//方法体只有一行
		int sum = testLambda4((a, b) -> a + b);
		System.out.println(sum);
		l2 = (a, b) -> 99;//方法体只有一行
		System.out.println(l2.add(55, 88));
	}

	public static void testLambda3(LambdaInterface t) {
		t.test();
	}

	public static int testLambda4(LambdaInterface2 t2) {
		return t2.add(10, 10);
	}
}

interface LambdaInterface {
	abstract void test();
}

interface LambdaInterface2 {
	abstract int add(int a, int b);
}
