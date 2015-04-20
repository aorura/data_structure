package simplelinkedlist;

public class SimpleLinkedList<T> extends CommonList implements IList<T> {
	private class DataNode {
		T data;
		DataNode next;
		
		public DataNode(T data, DataNode next) {
			this.data = data;
			this.next = next;
		}
	}
	
	DataNode head = null;
	
	private DataNode getNode(int index) {
		DataNode foundNode = head;
		
		for (int i=0; i < index; ++i) {
			foundNode = foundNode.next;
		}
		return foundNode;
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		DataNode newNode = null;
		
		if (head == null) {
			newNode = new DataNode(element, null);
			head = newNode;
		} else {
			DataNode lastNode = head;
			
			lastNode = getNode(size-1);
			newNode = new DataNode(element, null);
			lastNode.next = newNode;
		}
		++size;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		checkIndex(index);
		
		if (head == null) {
			add(element);
			return;
		}
		
		if (index == 0) {
			head = new DataNode(element, head);
			++size;
		} else if (index == size) {
			add(element);
		} else {
			DataNode prevNode = getNode(index-1);
			prevNode.next = new DataNode(element, prevNode.next);
			++size;
		}
	}

	@Override
	public void remove(int index) {
		checkIndex(index);
		
		DataNode targetNode = head;
		
		if (index == 0) {
			head = targetNode.next;
			targetNode.data = null;
			targetNode.next = null;
			targetNode = null;
		} else {
			DataNode prevNode = getNode(index-1);
			targetNode = prevNode.next;
			prevNode.next = targetNode.next;
			targetNode.data = null;
			targetNode.next = null;
			targetNode = null;
		}
		--size;
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		
		DataNode targetNode = head;
		
		if (element == null) {
			for (int i=0; i < size; ++i, targetNode = targetNode.next) {
				if (targetNode.data == null) {
					remove(i);
					return true;
				}
			}
		} else {
			for (int i=0; i < size; ++i, targetNode = targetNode.next) {
				if (element.equals(targetNode.data)) {
					remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void set(int index, T element) {
		// TODO Auto-generated method stub
		checkIndex(index);
		
		getNode(index).data = element;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		
		return getNode(index).data;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		DataNode targetNode = head;
		
		sb.append("Size : " + size + "\n");
		for (int i=0; targetNode != null; ++i, targetNode = targetNode.next) {
			sb.append(i + " : " + targetNode.data + "\n");
		}
		
		return sb.toString();
	}

}
