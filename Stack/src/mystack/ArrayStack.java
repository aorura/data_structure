package mystack;

import java.util.ArrayList;

public class ArrayStack<T> implements IStack<T>{
	class DataNode<T> {
		T data;
	}
	
	private int size = 0, top = -1;
	Object[] array = null;
	
	public ArrayStack(int size) {
		this.size = size;
		this.array = new Object[size];
	}

	@Override
	public void push(T data) {
		// TODO Auto-generated method stub
		if (top >= size) {
			
		}
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
