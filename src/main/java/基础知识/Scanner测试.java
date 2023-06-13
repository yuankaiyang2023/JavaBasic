package 基础知识;

import java.util.Scanner;

public class Scanner测试 {

	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		System.out.println("请输入名字：");
		String name = scanner.nextLine();
		System.out.println("请输入爱好：");
		String favor = scanner.nextLine();
		System.out.println("请输入年龄：");
		int age = scanner.nextInt();
		System.out.println("name: " + name + "\nfavour:" + favor + "\nage: " + age);
	}
}
