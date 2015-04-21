package mystack;

public class Test {
	public static void main(String args[]) {
		ArrayStack as = new ArrayStack(5);
		as.push(40);
		as.push(20);
		as.pop();
		as.push(30);
		as.push(40);
		
		System.out.print("What is top? = "  + as.top() + "\n");
		
		System.out.print("1st = " + as.pop() + "\n");
		System.out.print("2st = " + as.pop() + "\n");
		System.out.print("3st = " + as.pop() + "\n");
		System.out.print("4st = " + as.pop() + "\n");
	}
}
