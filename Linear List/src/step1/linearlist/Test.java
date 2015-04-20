package step1.linearlist;

public class Test {
	public static void main(String args[]) {
		LinearList list = new LinearList();
		
		for (int i=0; i < 4; ++i) {
			list.add("hello");
		}
		
		list.remove(1);
		list.add(3, "park");
		list.print();
	}
}
