package 基础知识;

public class This和static {
	public int n1;
	public static int n2;

	public This和static() {
	}

	public This和static(int n1, int n2) {
		this();// 调用构造函数
		this.n1 = n1;
		this.n2 = n2;
	}

	public void t1() {

		int s = this.n1;
		int s2 = this.n2;
		this.t1();
		this.t2();
		t2();
	}

	public static void t2() {
		
	}

	// this 指的是类的对象,不能出现在静态方法里，但可以调用静态方法，变量
	// this另一个用法：构造器里调用另一个构造器this(); 。构造方法用于对象的初始化，静态初始化块用于类的初始化（类初始化时执行静态块）
	// static变量，方法属于类，不可以调用普通方法和变量
	// 非静态方法可以调用静态方法
}
