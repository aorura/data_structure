package binarytree;

public class MainBinaryTreeArrayTest {
	public static void main(String args[]) {
		BinaryTreeArray tree = new BinaryTreeArray(2);
		
		tree.add(1);tree.add(2);tree.add(3);
		tree.add(4);tree.add(5);tree.add(6);
		tree.add(7);
		
		System.out.format("isEmpty=%b%n", tree.isEmpty());
		
		int cur = 1;
		System.out.println("find (5)");
		cur = cur * 2;
		cur = cur * 2 + 1;
		System.out.println("find (5)=" + tree.mData[cur]);
		System.out.println("size="+tree.size());
		System.out.println("edges="+tree.edges());
		
		tree.preorder();
		
	}
}
