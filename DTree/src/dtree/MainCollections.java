package dtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainCollections {
	public static void main(String[] args) {

		new MainCollections().test();
	}
	
	private void test0() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(55);list.add(5);list.add(2);list.add(3);list.add(1);list.add(2);
		
		Iterator<Integer> iter = list.iterator();
		//OR
		list.stream().forEach(c->System.out.println(c));
	}
	
	private void testIterationString() {
		List<Integer> list = Arrays.asList(55, 5, 2, 3);
		list.stream().forEach(action->System.out.format("%d, ", action));
	}
	// java stream
	private void test() {
		Stream.of(1,2,3,4).findFirst().ifPresent(System.out::println);
		IntStream.range(1,10).findFirst().ifPresent(System.out::println);
		Arrays.stream(new int[]{1,2,3}).map(n->2*n+1).average().ifPresent(System.out::println);
		Stream.of("a1", "a2", "a3", "a4", "a5").map(s->s.substring(1)).mapToInt(Integer::parseInt).average();
	}
}
