package IO流测试.装饰流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//数据序列化（持久化）
public class ObjectInputStream和ObjectOutputStream {
	public static void main(String[] args) throws ClassNotFoundException {
		copyDataToArrayThenReadFromArray();
		copyDataToFileThenReadFromFile("src/IO流测试/ioTestObjectOutputStream");
	}

	public static void copyDataToArrayThenReadFromArray() throws ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));// 双重装饰baos，扩展功能,核心功能仍然是节点流，装饰器将基本数据转化为字节数组并缓存
			oos.writeUTF("测试ObjectInputStream: ");
			oos.writeInt(1);
			oos.writeBoolean(true);
			Employee e = new Employee("王二", 22222);
			oos.writeObject(new Date());
			oos.writeObject("test");
			oos.writeObject(e);
			oos.flush();
			byte[] bytes = baos.toByteArray();
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(bytes)));
			String msg = ois.readUTF();
			int a = ois.readInt();
			boolean b = ois.readBoolean();
			Object date = ois.readObject();
			Object test = ois.readObject();
			Object employee = ois.readObject();
			if (date instanceof Date) {
				System.out.println(date);
			}
			if (test instanceof String) {
				System.out.println(test);
			}
			if (employee instanceof Employee) {
				System.out.println(((Employee) employee).getName() + "--->" + ((Employee) employee).getSalary());
			}
			System.out.println(msg);
			System.out.println(a);
			System.out.println(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 
 * @param str
 * @throws ClassNotFoundException
 */
	public static void copyDataToFileThenReadFromFile(String str) throws ClassNotFoundException {
		FileOutputStream file;
		try {
			file = new FileOutputStream(str);
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(file));// 双重装饰baos，扩展功能,核心功能仍然是节点流，装饰器将基本数据转化为字节数组并缓存
			oos.writeUTF("测试ObjectInputStream: ");
			oos.writeInt(1);
			oos.writeBoolean(true);
			Employee e = new Employee("王二", 22222);
			oos.writeObject(new Date());
			oos.writeObject("test");
			oos.writeObject(e);
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(str)));
			String msg = ois.readUTF();
			int a = ois.readInt();
			boolean b = ois.readBoolean();
			Object date = ois.readObject();
			Object test = ois.readObject();
			Object employee = ois.readObject();
			if (date instanceof Date) {
				System.out.println(date);
			}
			if (test instanceof String) {
				System.out.println(test);
			}
			if (employee instanceof Employee) {
				System.out.println(((Employee) employee).getName() + "--->" + ((Employee) employee).getSalary());
			}
			System.out.println(msg);
			System.out.println(a);
			System.out.println(b);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class Employee implements Serializable {
	private transient String name;// 不对name做序列号操作
	private double salary;

	public Employee() {
		super();

	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
