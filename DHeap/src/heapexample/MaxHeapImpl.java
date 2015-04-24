package heapexample;

public class MaxHeapImpl<T extends Comparable<T>> implements Heap<T>{
	
	private T[] mArray;
	private int mCurrent;
	
	@SuppressWarnings("unchecked")
	public MaxHeapImpl(int capacity) {
		// TODO Auto-generated constructor stub
		this.mArray = (T[]) new Comparable[capacity];
		this.mCurrent = 0;
	}

	@Override
	public boolean insert(T data) {
		// TODO Auto-generated method stub
		this.mCurrent++;
		this.mArray[mCurrent] = data;

		int cur = mCurrent;
		
		while (cur > 1) {
			int parent = cur / 2;
			if (this.mArray[cur].compareTo(this.mArray[parent]) > 0) {
				T tmp = this.mArray[parent];
				this.mArray[parent] = this.mArray[cur];
				this.mArray[cur] = tmp;
				cur = parent;
			} else {
				break;
			}
		}
		
		return true;
	}

	@Override
	public T delete() {
		// TODO Auto-generated method stub
		T r = this.mArray[1];
		this.mArray[1] = this.mArray[this.mCurrent];
		this.mArray[this.mCurrent--] = null;
		int max = -1;
		
		int cur = 1;
		while (cur <= this.mCurrent) {
			int left = cur * 2;
			int right = cur * 2 +1;
			
			if (right > this.mCurrent) {
				right = left;
			}
			
			if (left > this.mCurrent) {
				break;
			}
			
			if (this.mArray[left].compareTo(this.mArray[right]) > 0) {
				max = left;
			} else {
				max = right;
			}
			
			if (this.mArray[max].compareTo(this.mArray[cur]) > 0) {
				T tmp = this.mArray[max];
				this.mArray[max] = this.mArray[cur];
				this.mArray[cur] = tmp;
			} else {
				break;
			}
			
			
		}
		return r;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
