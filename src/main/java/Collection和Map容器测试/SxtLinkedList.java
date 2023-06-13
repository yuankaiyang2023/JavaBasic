package Collection和Map容器测试;

public class SxtLinkedList<E> {
	Node first;
	Node last;
	int size;

	public void add(E element) {
		Node newNode = new Node(element);
		if (first == null) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
			last = newNode;
		}
		size++;
	}

	public void remove(int index) {
		checkIndex(index);
		Node node = getNode(index);
		if (node.previous != null)
			node.previous.next = node.next;
		else
			first = node.next;
		if (node.next != null)
			node.next.previous = node.previous;
		else
			last = node.previous;
		size--;
	}

	public void add(E element, int index) {
		Node newNode = new Node(element);
		if (size != 0) {
			checkIndex(index);
			Node node = getNode(index);
			if (node.previous != null)
				node.previous.next = newNode;
			else
				first = newNode;
			newNode.previous = node.previous;
			newNode.next = node;
			node.previous = newNode;
		} else if (size == 0) {
			if (index != 0)
				throw new RuntimeException("链表长度为 0,索引不为合法 :" + index);
			else {
				first = newNode;
				last = newNode;
			}
		}
		size++;

	}

	public E get(int index) {
		checkIndex(index);
		Node node = getNode(index);
		return node != null ? (E) node.element : null;
	}

	private Node getNode(int index) {
		checkIndex(index);
		Node node;
		if (index <= size >> 2) {
			node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.previous;
			}
		}
		return node;
	}

	private void checkIndex(int index) {
		if (size == 0) {
			throw new RuntimeException("链表长度为 0, index: " + index);
		} else if (index < 0 || index > size - 1) {
			throw new RuntimeException("索引不合法" + index);
		}
	}

	@Override
	public String toString() {
		if (size == 0)
			return "[]";
		StringBuilder str = new StringBuilder();
		str.append("[");
		Node node = first;
		while (node != null) {
			str.append(node.element + ",");
			node = node.next;
		}

		str.setCharAt(str.length() - 1, ']');
		return str.toString();
	}

	public static void main(String[] args) {
		SxtLinkedList<String> list = new SxtLinkedList<String>();

		// list.add("cc4", 0);
		System.out.println(list);
		list.add("c", 0);
		System.out.println(list);
		list.add("b", 0);
		list.add("b2", 0);
		list.add("b3", 0);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		System.out.println(list.first.element);
	}
}
