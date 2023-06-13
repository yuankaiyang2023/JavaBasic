package Collection和Map容器测试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collections工具类 {
public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	Collections.sort(list);
	Collections.reverse(list);
	Collections.shuffle(list);//随机排序
	Collections.fill(list, "d");//特定元素重写整个容器
	Collections.binarySearch(list, "d");
}
}
