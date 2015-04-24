package heapexample;

public class MainMaxHeapTest {
	public static void main(String args[]) {
		MaxHeapImpl<Integer> heapMax = new MaxHeapImpl<Integer>(10);
		
		heapMax.insert(20);
		heapMax.insert(15);
		heapMax.insert(19);
		heapMax.insert(8);
		heapMax.insert(13);
		heapMax.insert(10);
		
		System.out.println(heapMax.delete());
		System.out.println(heapMax.delete());
		System.out.println(heapMax.delete());
		System.out.println(heapMax.delete());
		System.out.println(heapMax.delete());
	}
}
