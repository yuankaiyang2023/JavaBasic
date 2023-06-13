package Collection和Map容器测试;

public class Node3<K, V> {

	public Node3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node3(int hash, K k, V v) {
		super();
		this.hash = hash;
		this.k = k;
		this.v = v;
	}

	int hash;
	K k;
	V v;
	Node3 next;

}
