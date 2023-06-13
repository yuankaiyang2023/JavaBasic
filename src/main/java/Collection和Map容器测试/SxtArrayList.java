package Collection和Map容器测试;

import java.util.Arrays;

public class SxtArrayList<E> {

	private Object[] elementData;
	private int size;// 实际元素的个数
	private static final int DEFAULT_CAPACITY = 10;// 默认容器的容量

	public SxtArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public SxtArrayList(int capacity) {
		if (capacity < 0) {
			throw new RuntimeException("容器的容量不能小于0");
		} else if (capacity == 0) {

			elementData = new Object[DEFAULT_CAPACITY];
		} else {
			elementData = new Object[capacity];
		}
	}

	public void add(E element) {
		if (size == elementData.length) {
			Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = element;
	}

	public E get(int index) {
		checkRange(index);
		return (E) elementData[index];
	}

	public void set(E element, int index) {
		checkRange(index);
		elementData[index] = element;
	}

	public void checkRange(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("索引不合法" + index);
		}
	}

	public void remove(E element) {
		for (int i = 0; i < size; i++) {
			if (element.equals(get(i))) {
				remove(i);
			}
		}
	}

	public void remove(int index) {
		checkRange(index);
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		elementData[--size] = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	@Override
	public String toString() {
		// return "SxtArrayList [elementData=" + Arrays.toString(elementData) + ",
		// size=" + size + "]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(elementData[i] + ",");
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();

	}

	public static void main(String[] args) {
		SxtArrayList<String> s = new SxtArrayList<>(10);
		s.add("sss");
		s.add("bbb");
		for (int i = 0; i < 100; i++) {
			s.add("s" + i);
		}
		System.out.println(s);
		System.out.println(s.elementData.length + "\t" + s.size);
		System.out.println(s.get(100));
		s.remove(3);
		System.out.println(s);

	}

}
