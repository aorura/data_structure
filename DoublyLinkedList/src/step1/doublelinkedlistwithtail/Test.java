package step1.doublelinkedlistwithtail;

import java.util.Random;

public class Test {
	public static void main(String args[]) {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		Random rand = new Random();
		
		for (int i=0; i < 10; ++i) {
			list.add("hello");
		}
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		for (int i=0; i < 10; ++i) {
			int index = rand.nextInt(list.size-1);
            String ch = Integer.toString(index);
			System.out.println("add index : " + index + " ch: " + ch);
			list.add(index, ch);
			System.out.println(list);
		}
	}
}
