package binarytree;

public interface BinaryTree<T> {
	public int height();
	public int edges();
	public int size();
	public boolean add(T item);
	public T get();
	public boolean isEmpty();
}
