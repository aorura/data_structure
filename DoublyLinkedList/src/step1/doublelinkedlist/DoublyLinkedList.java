package step1.doublelinkedlist;

import simplelinkedlist.SimpleLinkedList.DataNode;

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
		
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
