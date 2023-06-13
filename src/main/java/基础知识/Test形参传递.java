package 基础知识;

public class Test形参传递 {
	String s="abc";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test形参传递 aTest= new Test形参传递();
		BTest bTest= new BTest();
		String s2=new String("ssss");
		bTest.setName(s2);
		System.out.println(s2);
		bTest.setFavor(aTest);
		System.out.println(bTest.favor+"\n"+aTest.s);
	}

}
class BTest{
	String name;
	String favor;
	public void setName(String s) {
		this.name=s;
		s="111";
	}
	public void setFavor(Test形参传递 a) {
		this.favor=a.s;
		a.s="222";
	}
}
//基本数据类型传递的时值，不影响原本，
//引用类型传递的是地址，副本和原引用指向同一个对象，会改变原对象数据。（String除外）