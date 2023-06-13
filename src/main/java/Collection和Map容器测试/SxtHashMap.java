package Collection和Map容器测试;

//遍历map可以用增强for循环，或者iterator遍历
public class SxtHashMap<K, V> {

	public SxtHashMap() {
		super();
		table = new Node3[16];
	}

	Node3[] table;// bucket arry,位桶数组， 用于存放每个链表的第一个节点
	int size;// 键值对总个数

	public static int hash(int hashCode, int length) {
		return hashCode & (length - 1);
	}

	public V get(K k) {
		V v = null;
		int hashValue = hash(k.hashCode(), table.length);
		Node3 temp = table[hashValue];
		while (temp != null) {
			if ((temp.k == null && k == null) || (temp.k != null && temp.k.equals(k))) {
				return (V) temp.v;
			}
			temp = temp.next;
		}
		return v;

	}

	public void put(K k, V v) {
		int hashValue = hash(k.hashCode(), table.length);
		Node3<K, V> node = new Node3(hashValue, k, v);
		Node3 temp = table[hashValue];
		Node3 lastNode = null;
		boolean keyRepeat = false;
		if (temp == null) {
			table[hashValue] = node;
			size++;
		} else {
			while (temp != null) {

				if ((temp.k == null && k == null) || (temp.k != null && temp.k.equals(k))) {
					temp.v = v;
					keyRepeat = true;
					break;
				}
				lastNode = temp;
				temp = temp.next;
			}
			if (!keyRepeat) {
				lastNode.next = node;
				size++;
			}
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (size == 0)
			return "{}";
		StringBuilder str = new StringBuilder("[");
		for (int i = 0; i < table.length; i++) {
			Node3 node = table[i];
			while (node != null) {
				str.append(node.k + ":" + node.v + ",");
				node = node.next;
			}
		}
		str.setCharAt(str.length() - 1, ']');
		return str.toString();
	}

	public static void main(String[] args) {
		SxtHashMap<Integer, String> map = new SxtHashMap();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "b2");
		map.put(33, "c");
		// map.put(33, "b");
		System.out.println(map.get(20));
	}
}
