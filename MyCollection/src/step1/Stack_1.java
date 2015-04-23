package step1;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack_1<T> {
	private T[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	@SuppressWarnings("unchecked")
	public Stack_1() {
		elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(T e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public T pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		T result = elements[--size];
		elements[size] = -1;
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2*size+1);
		}
	}
}
