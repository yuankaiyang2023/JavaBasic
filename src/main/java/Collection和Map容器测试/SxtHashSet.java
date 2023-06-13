package Collection和Map容器测试;

import java.util.HashMap;
import java.util.Map.Entry;

public class SxtHashSet<K> {
	HashMap<K, Object> map;
	static final Object PERSENT = new Object();

	public SxtHashSet() {
		super();
		map = new HashMap<>();
	}

	public void add(K k) {
		map.put(k, PERSENT);
	}

	public int size() {
		return map.size();
	}

	@Override
	public String toString() {
		if (size() == 0)
			return "[]";
		StringBuilder str = new StringBuilder("[");
		// TODO Auto-generated method stub
		for (Entry<K, Object> entry : map.entrySet()) {
			str.append(entry.getKey() + ",");
		}
		str.setCharAt(str.length() - 1, ']');
		return str.toString();
	}

	public static void main(String[] args) {
		SxtHashSet<String> set = new SxtHashSet<String>();
		set.add("22");
		set.add("sss");
		System.out.println(set.toString());
	}
}
