package 基础知识;

public interface Interface和AbstractClass {
	public static final int a = 0;
	 int b = 0;//抽象类 变量必须初始化 
	default void method1() {
		System.out.println(111);
	}

	 static void method2() {
		System.out.println(222);
	}

	public void method();
}

interface Interface2 {

}

interface Interface3 {

}

class Class1 implements Interface和AbstractClass, Interface2, Interface3 {

	@Override
	public void method() {
		// TODO Auto-generated method stub
		Class1 c = new Class1();
		c.method1();
	//	Class1.method2();
		
	}

	public void method5() {
		Interface和AbstractClass.method2();
	}


}

interface Interface4 extends Interface和AbstractClass, Interface2, Interface3 {
	static void method3() {
		Interface和AbstractClass.method2();
	}
}
//接口可以多继承其他接口，接口可以被多实现
//接口可以有default和static修饰的普通方法（jdk1.8之后）
//接口里默认方法为抽象方法，必须被实现
//接口不能被实例化

abstract class Class2 {
	public void method() {
		 
		System.out.println(333);
	}
	public abstract void method2();
}

class Class3 extends Class2{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	void method3() {
		Class2 c = new Class2() {
			
			@Override
			public void method2() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
//抽象方法只能在抽象类或者接口中
//抽象类不能被实例化
//抽象类子类或接口实现类必须要重写抽象方法
//抽象类里的抽象方法必须要加abstract修饰，接口里的抽象方法不需要加，默认为抽象方法