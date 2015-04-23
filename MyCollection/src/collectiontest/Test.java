package collectiontest;

import java.util.ArrayList;

public class Test {
	public static void addElement(ArrayList<Object> list, Object o) {
		list.add(o);
	}
	
	public static void print(ArrayList<Object> list) {
		int size = list.size();
		
		for (int i=0; i < size; ++i) {
			Object s = (Object) list.get(i);
			System.out.println("result of get() : " + s);
		}
	}
	
	public static void main(String args[]) {
		ArrayList<Object> arraylist = new ArrayList<Object>();
		
		addElement(arraylist, "1");
		addElement(arraylist, "2");
		addElement(arraylist, "3");
		addElement(arraylist, "4");
		print(arraylist);
	}
}
