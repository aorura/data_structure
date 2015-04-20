package simplelinkedlist;

public class Test {
	public static void main(String args[]) {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		
		for (int i=0; i < 4; ++i) {
			list.add("hello");
		}
		System.out.println(list);
		list.remove(1);
		list.add(2, "park");
		System.out.println(list);
	}
}
