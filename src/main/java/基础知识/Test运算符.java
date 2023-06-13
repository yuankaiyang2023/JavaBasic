package 基础知识;

public class Test运算符 {

	public static void main(String[] args) {
		//3: 0011 
		System.out.println(~3);//1100
		System.out.println(0&3);//0000
		System.out.println(0|3);//0011
		System.out.println(0^3);//0011
		//优先级： (),!,+,-,~,++,--,*,/,%,+.-,<<,>>,>,>=,<,<=,==,!=,&,^,|,&&,||,?:,=,+=,-=,*=,/=,%=
		//一元运算符，乘除取余加减，位左移右移，比较运算符，逻辑运算符，三元运算符，赋值运算符。         逻辑与>逻辑或
	}

}
