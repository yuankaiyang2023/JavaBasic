package 基础知识;

public class InnerClass测试 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer o0 = new Outer();
		Outer.Inner inner = o0.new Inner();
		inner.show();
		System.out.println("o0.age222:" + o0.age222);
		Outer.StaticInner staticInner = new Outer.StaticInner();
		Outer o1 = new Outer();
		o1.showAnonymous(new AnonymousClass() {

			@Override
			public void show() {
				// TODO Auto-generated method stub
				
				System.out.println("InnerClass测试.main(...).new AnonymousClass() {...}.show()");
			}
		});
		o1.showMethodInner();
	}
 void show2() {
		Outer o0 = new Outer();
		Outer.Inner inner = o0.new Inner();
 }
}

class Outer {
	 int age222;

	void testOuter() {
		// Inner.this.age;--No enclosing instance of the type Inner is accessible in
		// scope--在作用域中不能访问任何Inner类型的封闭实例
		Inner i = new Inner();
		int age2 = i.age;// 需要实例化才能访问内部类属性
		i.show();
		StaticInner.number=9;//可以直接访问静态类的静态属性
	}

	static void testOuter2() {
	}

class Inner {
		 int age;
		final static int number =0;

		public void show() {
			int age = 0;
			age222 =10;
			System.out.println(Outer.this.age222);// 成员变量
			System.out.println(this.age);// 成员变量
			System.out.println(age);// 局部变量
			Outer.testOuter2();

		}

	}

	static class StaticInner {
		private int age;
		static int number;
		public void show() {
			int age = 0;
			// System.out.println(Outer.this.age);//成员变量
			System.out.println(this.age);// 成员变量
			System.out.println(age);// 局部变量
			Outer.testOuter2();

		}
	}

	void showAnonymous(AnonymousClass a) {
		a.show();
	}

	void showMethodInner() {
		class MethodInner {
			void fun() {
				System.out.println("Outer.showMethodInner().MethodInner.fun()");
			}
		}
		MethodInner m = new MethodInner();// 局部内部类只能在方法里使用，用于解决复杂问题，创建一个辅助类，并且不希望是公用的
		m.fun();
	}
}
//非静态内部类寄存在一个外部类对象里，单独属于外部类的某个对象
//非内部类可以直接访问外部类属性,private也可以，外部类无法直接访问内部类属性，提供封装性
//非静态内部类不能定义静态变量，方法，初始化块
//外部静态方法，代码块不能访问非静态内部类

//调用静态内部类不需要创建外部类的实例，使用new Outer.Inner();
//静态内部类无法调用外部类的非静态方法,属性

//匿名内部类一般用于监听操作
//内部类
interface AnonymousClass {
	void show();
}