package step1.doublelinkedlistwithtail;

public class CommonList {
	protected int size = 0;
	
	protected void checkIndex(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Wrong Index!! Index: " + index + ", Size: " + size);
		}
	}
	
	public int getListSize() {
		return size;
	}
}
