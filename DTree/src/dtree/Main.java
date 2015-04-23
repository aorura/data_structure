package dtree;

import java.util.Iterator;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		map.put(0,  "s");
		
		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			System.out.println("map=" + iter.next());
		}
	}
}
