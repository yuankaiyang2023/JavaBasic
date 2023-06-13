package Collection和Map容器测试;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
//Collection 包含了list和set，不包含map
public class Collection基本操作 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		List<String> c2 = new ArrayList<String>();
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		c.add("11");
		c.add("2");
		System.out.println(c);
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		c.remove("2");
		System.out.println(c);
		c.clear();
		System.out.println(c);
		c.add("11");
		c.add("2");
		c.add("4");
		c.add("5");
		Object[] s=c.toArray();
		System.out.println(s.toString());
		System.out.println(c.contains("2"));
		//containsAll,addAll,removeAll去除交集,retainAll保留交集
		c2.add("2");
		c2.add("5");
		System.out.println(c2.containsAll(c));
		//List
		//add,set,remove,indexOf,lastIndexOf
    
		
		//List有序可重复，ArrayList用index下标查找数据时比较快O(1)，其他情况并不快，为O(n)
		//LinkedList是双向链表，可以从后面往前查
		//Set无序不可重复
		//HashMap无序，键不可重复，插入顺序无序，输出顺序固定
		//Map不是Collection的子类
		//Collection是接口，Collections是工具类
	}
}
