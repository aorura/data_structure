package step1;

public class TestStack {
	public static void main(String args[]) {
		Stack_1 stack = new Stack_1();
		
		stack.push("Test1");
		stack.push("Test2");
		
		String result1 = stack.pop();
		String result2 = stack.pop();
		
		stack.push(1);
		stack.push(2);
		
		int result3 = stack.pop();
		int result4 = stack.pop();
	}
}
