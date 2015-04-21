package step1.doublelinkedlist;

public class Test {
	public static void main(String args[]) {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		
		for (int i=0; i < 4; ++i) {
			list.add("hello");
		}
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.add(list.size-1, "park");
		System.out.println(list);
	}
}
