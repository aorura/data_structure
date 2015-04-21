package step1.doublelinkedlistwithtail;

public class DoublyLinkedList<T> extends CommonList implements IList<T> {
	private class DataNode {
		DataNode next, prev;
		T data;
		
		public DataNode(DataNode prev, T data, DataNode next) {
			this.next = next;
			this.data = data;
			this.prev = prev;
		}
	}

	DataNode head = null;
	DataNode tail = null;
	
//	private DataNode getNode(int index) {
//		DataNode foundNode = head;
//		
//		for (int i=0; i < index; ++i) {
//			foundNode = foundNode.next;
//		}
//		return foundNode;
//	}
	private DataNode getNode(int index) {
		DataNode foundNode = null;
		if (index > size/2) {
			foundNode = tail;
			
			for (int i=1; i < size - index; ++i) {
				foundNode = foundNode.prev;
			}
		} else {
			foundNode = head;
			
			for (int i=0; i < index; ++i) {
				foundNode = foundNode.next;
			}
		}

		return foundNode;
	}
	
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		if (head == null) {
			DataNode newNode = new DataNode(null, element, null);
			head = newNode;
			tail = newNode;
		} else {
			DataNode newNode = new DataNode(tail, element, null);
			tail.next = newNode;
			tail = newNode;
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
		
		DataNode targetNode = getNode(index);
		
		if (index == 0) {
			DataNode newNode = new DataNode(null, element, targetNode);
			targetNode.prev = newNode;
			head = newNode;
		} else {
			DataNode newNode = new DataNode(targetNode.prev, element, targetNode);
			targetNode.prev.next = newNode;
			targetNode.prev = newNode;
		}
		++size;
	}

	@Override
	public void remove(int index) {
		checkIndex(index);
		
		DataNode targetNode = getNode(index);
		
		if (index == 0) {
			head = targetNode.next;
			head.prev = null;
			
			if (head == null) {
				tail = head;
			}
		} else if (index == size - 1) {
			targetNode.prev.next = null;
			tail = targetNode.prev;
		}else {
			targetNode.prev.next = targetNode.next;
			targetNode.next.prev = targetNode.prev;
		}
		targetNode.prev = null;
		targetNode.data = null;
		targetNode.next = null;
		--size;
	}

	@Override
	public boolean remove(T element) {
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
		DataNode targetNode = getNode(index);
		targetNode.data = element;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		DataNode targetNode = getNode(index);
		return targetNode.data;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		DataNode targetNode = head;
		
		sb.append("SIZE: " + size + "\n");
		for (int i=0; targetNode != null; ++i, targetNode = targetNode.next) {
			sb.append(i + " : " + targetNode.data + "\n");
		}
//		sb.append("\n");
//		targetNode = getNode(size-1);
//		for (int i=size-1; targetNode != null; --i, targetNode = targetNode.prev) {
//			sb.append(i + " : " + targetNode.data + "\n");
//		}
		return sb.toString();
	}
}
