package 基础知识;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception测试 {// 后期开发通常层层外抛，高层处理
	public static void main(String[] args) throws IllegalNameException {
		FileReader f = null;
		try {
			f = new FileReader("D:/book.txt");
			char c1 = (char) f.read();
			System.out.println(c1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { // 子类异常在父类异常前面，否则执行不到子类异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (f != null) {
					f.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Person p = new Person();
//		try {
//			p.setName(null);
//		} catch (IllegalNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		p.setName(null);// throws 抛出异常将不会执行下面代码，try catch处理则会继续执行下面代码
		p.setAge(-10);
	}
}

class IllegalAgeException extends RuntimeException {// 运行时异常，不需要处理，交给虚拟机捕获
	public IllegalAgeException() {

	}

	public IllegalAgeException(String msg) {
		super(msg);
	}
}

class IllegalNameException extends Exception {// 编译时异常，需要做catch或者throws处理
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalNameException() {

	}

	public IllegalNameException(String msg) {
		super(msg);
	}
}

class Person {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalNameException {
		if (name == null) {
			throw new IllegalNameException("名字不能为空");

		}
		this.name = name;
	}

	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalAgeException("年龄不能为负数");
		}
		this.age = age;
	}

}