package 基础知识;
/**
 * for循环测试，打印乘法表 
 * @author Yang
 *
 */
public class For循环 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			}
			System.out.println();
		}
		int count = 0;
		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.print(i + "\t");
			count++;
			if (count % 5 == 0)
				System.out.println();
		}
	}

}
