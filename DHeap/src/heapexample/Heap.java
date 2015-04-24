package heapexample;

public interface Heap<T> {
	boolean insert(T data);
	T delete();
	boolean isEmpty();
}
