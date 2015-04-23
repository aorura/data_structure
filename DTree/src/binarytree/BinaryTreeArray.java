package binarytree;

import java.lang.reflect.Array;
import java.util.Objects;

public class BinaryTreeArray implements BinaryTree {

	private int mHeight;
	private int mCapacity;
	protected Object[] mData;
	private int mIndexCur;

	public BinaryTreeArray(int height) {
		this.mHeight = height;
		this.mCapacity = (int) Math.pow(2, height + 1);
		this.mData = (Object[]) Array.newInstance(Object.class, mCapacity);
		this.mIndexCur = 1;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.mIndexCur - 1;
	}

	@Override
	public boolean add(Object item) {
		if (this.mIndexCur < this.mData.length) {
			this.mData[this.mIndexCur++] = item;
		}
		return true;
	}

	@Override
	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		return this.mIndexCur <= 1;
	}

	public void preorder() {
		// TODO Auto-generated method stub
		System.out.println("preorder()=");
		_preorder(1);
		System.out.println();
	}

	private void _preorder(int i) {
		// TODO Auto-generated method stub
		if (i >= this.mData.length) {
			return;
		}
		
		//guava
		if (Objects.isNull(this.mData[i]))  {
			return;
		}
		
		//pre-order
		//1.process
		//2.left
		//3.right
		
		System.out.print(this.mData[i]+", ");
		_preorder(2*i);
		_preorder(2*i+1);
	}
	
	public void inorder() {
		// TODO Auto-generated method stub
		System.out.println("preorder()=");
		_inorder(1);
		System.out.println();
	}
	//vistor pattern
	public void _inorder(int i) {
		//in-order
		//1.left
		//2.process
		//3.right
		if (i >= this.mData.length) {
			return;
		}
		
		//guava
		if (Objects.isNull(this.mData[i]))  {
			return;
		}
		
		_inorder(2*i);
		System.out.print(this.mData[i]+", ");
		_inorder(2*i+1);
	}
	
	public void postorder() {
		//post-order
		//1.left
		//2.right
		//3.process
		System.out.println("preorder()=");
		_postorder(1);
		System.out.println();
	}
	
	public void _postorder(int i) {
		if (i >= this.mData.length) {
			return;
		}
		
		//guava
		if (Objects.isNull(this.mData[i]))  {
			return;
		}
		
		_inorder(2*i);
		_inorder(2*i+1);
		System.out.print(this.mData[i]+", ");
		
	}

}
