package binarytree;

class Node<K extends Comparable<K>, V> {
	protected Node<K, V> mLeft;
	protected Node<K, V> mRight;
	protected K mKey;
	protected V mValue;

	public Node(K key, V value) {
		// TODO Auto-generated constructor stub
		mKey = key;
		mValue = value;
	}
}

public class BinarySearchingTree<K extends Comparable<K>, V> {
	public Node<K, V> mRoot;

	public V get(K key) {
		Node<K, V> cur = mRoot;

		while (cur != null) {

			if (cur.mKey == key) {
				return cur.mValue;
			}

			if (key.compareTo(cur.mKey) < 0) {
				cur = cur.mLeft;
			} else {
				cur = cur.mRight;
			}
		}
		return null;
	}

	public void put(K key, V value) {
		Node<K, V> cur = mRoot, parent = null, newNode = null;

		while (cur != null) {
			if (key.compareTo(cur.mKey) == 0) {
				return;
			}
			parent = cur;
			if (key.compareTo(cur.mKey) < 0) {
				cur = cur.mLeft;
			} else {
				cur = cur.mRight;
			}
		}

		newNode = new Node<K, V>(key, value);

		if (mRoot == null) {
			mRoot = newNode;
			return;
		}

		if (newNode.mKey.compareTo(parent.mKey) < 0) {
			parent.mLeft = newNode;
		} else {
			parent.mRight = newNode;
		}
	}

	boolean isRemoved  = false;
	public boolean remove(K key) {
		isRemoved = false;
		
		return _deleteChild(mRoot, key) != null;
		// TODO Auto-generated method stub
	}

	private Node<K, V> _deleteChild(Node<K, V> cur, K key) {
		// TODO Auto-generated method stub
		Node<K, V> target = null;

		if (cur == null) {
			return null;
		}

		if (key.compareTo(cur.mKey) < 0) {
			target = _deleteChild(cur.mLeft, key);
			cur.mLeft = (target == null) ? null : target;
			//left
		} else if (key.compareTo(cur.mKey) > 0) {
			target = _deleteChild(cur.mRight, key);
			cur.mLeft = (target == null) ? null : target;
			//right
		} else if (key.compareTo(cur.mKey) == 0) {
			isRemoved = true;
			if (cur.mLeft == null && cur.mRight == null) {
				 return null;
			} else if (cur.mLeft != null && cur.mRight == null) {
				return cur.mLeft;
			} else if (cur.mLeft == null && cur.mRight != null) {
				return cur.mRight;
			} else {
				Node<K, V> maxNode = _findMax(cur.mLeft);
				if (maxNode != null) {
					return maxNode;
				}
				
				Node<K, V> minNode = _findMin(cur.mRight);
				if (minNode != null) {
					return minNode;
				}
			}
		}

		return cur;
	}

	// 제대로 구현해보기
	private Node<K, V> _findMin(Node<K, V> cur) {
		// TODO Auto-generated method stub
		if (cur == null) {
			return null;
		}
		
		if (cur.mLeft != null) {
			return _findMin(cur.mLeft);
		}
		return cur;
	}

	// 제대로 구현해보기
	private Node<K, V> _findMax(Node<K, V> cur) {
		// TODO Auto-generated method stub
		if (cur == null) {
			return null;
		}
		
		if (cur.mRight != null) {
			return _findMax(cur.mRight);
		}
		return cur;
	}
}
