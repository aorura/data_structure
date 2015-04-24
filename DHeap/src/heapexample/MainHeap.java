package heapexample;

import java.util.PriorityQueue;

public class MainHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(45);
		pq.add(35);
		pq.add(95);
		pq.add(70);
		
		System.out.println("" + pq.poll());
		System.out.println("" + pq.poll());
		System.out.println("" + pq.poll());
		System.out.println("" + pq.poll());
		
	}

}
