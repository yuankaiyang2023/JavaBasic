package 基础知识;


 public class Enum测试{
	public static void main(String[] args) {
		System.out.println(Season.AUTUMN);
	}
}

 enum Season { //枚举类配合switch使用
 SPRING,SUMMER,AUTUMN,WINTER
}