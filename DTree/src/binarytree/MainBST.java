package binarytree;

public class MainBST {

	public static void main(String[] args) {
		BinarySearchingTree<Integer, String> bst = new BinarySearchingTree<Integer, String>();
		
//		bst.mRoot = new Node<Integer, String>(8, "8");
//		bst.mRoot.mLeft = new Node<Integer, String>(6, "6");
//		bst.mRoot.mRight = new Node<Integer, String>(8, "8");
		bst.put(8, "8");
		bst.put(6, "6");
		bst.put(10, "10");
		bst.put(10, "14");
		bst.put(10, "11");
		bst.put(10, "16");
		
		System.out.println(bst.get(6));
		System.out.println(bst.remove(4));

	}

}
