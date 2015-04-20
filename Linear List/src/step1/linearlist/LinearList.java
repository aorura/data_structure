package step1.linearlist;

import java.util.Arrays;

public class LinearList extends CommonList implements IList {
	private int MAX_CAPACITY = 10;
	private String[] elementData = null;
	
	public LinearList() {
		elementData = new String[MAX_CAPACITY];
	}
	
	private void ensureCapacity() {
		if (size >= MAX_CAPACITY) {
			elementData = Arrays.copyOf(elementData, size*2);
			MAX_CAPACITY *= 2;
		}
	}

	@Override
	public void add(String element) {
		// TODO Auto-generated method stub
		ensureCapacity();
		elementData[size++] = element;
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		if (index == size) {
			add(element);
		} else {
			checkIndex(index);
			ensureCapacity();
			System.arraycopy(elementData, index, elementData, index+1, size - index);
			elementData[index] = element;
			size++;
		}
	}

	@Override
	public void remove(int index) {
		checkIndex(index);
		int movingCount = size - (index + 1);
		
		if (movingCount > 0) {
			System.arraycopy(elementData, index+1, elementData, index, movingCount);
			elementData[--size] = null;
		}
	}

	@Override
	public boolean remove(String element) {
		// TODO Auto-generated method stub
//		for (int i=0; i < size; ++i) {
//			if (elementData[i].equals(element)) {
//				remove(i);
//				return true;
//			}
//		}
		
		if (element == null) {
			for (int i=0; i < size; ++i) {
				if (elementData[i] == null) {
					remove(i);
					return true;
				}
			}
		} else {
			for (int i=0; i < size; ++i) {
				if (element.equals(elementData[i])) {
					remove(i);
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public void set(int index, String element) {
		// TODO Auto-generated method stub
		checkIndex(index);
		elementData[index] = element;
	}
	
	@Override
	public String get(int index) {
		checkIndex(index);
		return elementData[index];
	}
	
	public void print() {
		for (int i=0; i < elementData.length; ++i) {
			System.out.println(i + " : " + elementData[i]);
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Size: " + size + "]\n");
		for (int i=0; i < size; ++i)
			sb.append(i + " : " + elementData[i] +"\n");
		return sb.toString();
	}
}
