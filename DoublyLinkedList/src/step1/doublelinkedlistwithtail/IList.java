package step1.doublelinkedlistwithtail;

public interface IList<E> {
	void add(E element);
	void add(int index, E element);
	void remove(int index);
	boolean remove(E element);
	void set(int index, E element);
	E get(int index);
	String toString();
}
