package myqueue_circular;

public interface IQueue {
	boolean isEmpty();
	boolean isFull();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}
