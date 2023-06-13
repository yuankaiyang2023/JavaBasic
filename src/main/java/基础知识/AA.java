package 基础知识;

public class AA {
	
	boolean b;
	public static void main(String[] args) {
		AA aa = new AA();
		System.out.println(aa.b);
		BallGame.a=1;
		
		BallGame.a=2;
		System.out.println(1111);
		CC c= new CC();
		c.test();
		DD d= new DD();
		d.test();
	}

}

class CC {
	void test(){
		System.out.println(BallGame.a);
		BallGame.a=9;
	}
}

class DD {
	void test(){
		System.out.println(BallGame.a);
	}
}