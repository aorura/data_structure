package mystack;

public interface IStack<E> {
	void push(E data);
	E pop();
	E top();
	boolean isEmpty();
}
