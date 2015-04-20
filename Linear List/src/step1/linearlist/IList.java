package step1.linearlist;

public interface IList {
	void add(String element);
	void add(int index, String element);
	void remove(int index);
	boolean remove(String element);
	void set(int index, String element);
	String get(int index);
}
