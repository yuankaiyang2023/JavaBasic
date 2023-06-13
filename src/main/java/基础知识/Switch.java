package 基础知识;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int month = (int)(1+Math.random()*12);
		int month = 2;
		System.out.println("month: " + month);
		switch (month) {
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
		}
		System.out.println("************");
		testAlphabet();

	}

	public static void testAlphabet() {

		char letter = (char) ('a' + (int) (26 * Math.random()));
		switch (letter) {
		case 'a':
		case 'o':
		case 'e':
		case 'i':
		case 'u':
			System.out.println("元音字母： " + letter);// 遇到一个满足条件会一直向下走，不管后面是否满足条件，直到遇见break；
			break;
		case 'y':
		case 'w':
			System.out.println("半元音字母： " + letter);
			break;
		default:
			System.out.println("辅音" + letter);
		}
	}
}
