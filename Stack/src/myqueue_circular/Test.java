package myqueue_circular;

public class Test {
	public static void main(String args[]) {
		ArrayQueue as = new ArrayQueue(5);
		as.enQueue('a');
		as.enQueue('b');
		as.enQueue('c');
		as.enQueue('d');
		as.enQueue('e');
		as.enQueue('f');
		as.enQueue('g');
		as.enQueue('h');
//		as.deQueue();
		
//		as.enQueue('d');
//		as.printQueue();
//		
//		System.out.print("1st = " + as.deQueue() + "\n");
//		System.out.print("2st = " + as.deQueue() + "\n");
//		System.out.print("3st = " + as.deQueue() + "\n");
//		System.out.print("4st = " + as.deQueue() + "\n");
//		as.printQueue();
	}
}
