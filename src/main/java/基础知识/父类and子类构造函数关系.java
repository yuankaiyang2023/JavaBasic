package 基础知识;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 父类and子类构造函数关系 {

	public static void main(String[] args) {
		Father c = new Child(555);
		c.say();
	}

}

class Father {
	int a;

	public Father() {
		a = 99;
	}

	public Father(int a) {
		this.a = a;
	}

	void say() {
		System.out.println(1111);
	}
}

class Child extends Father {

	public Child() {
		 super();
	}

	public Child(int a) {
		super();
	//	super(a); //子类可以指定父类调用哪一个构造函数，父类的非私有属性子类对象可以直接使用
	}

	@Override
	void say() {
		// this.a =3;
		System.out.println(222);
		System.out.println(a);
	}
}
