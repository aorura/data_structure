package dgraphe;

import java.util.ArrayList;
import java.util.Iterator;

public class UndirectGraphMatrix<V, E extends Comparable<E>> implements Graph<V, E> {
	final ArrayList<V> mVertexList = new ArrayList<V>();
	final ArrayList<ArrayList<E>> mMatrix = new ArrayList<ArrayList<E>>();
	
	
	@Override
	public void addVertex(V vertex) {
		// TODO Auto-generated method stub
		mVertexList.add(vertex);
		mMatrix.add(new ArrayList<E>());
	}

	@Override
	public void addEdge(V start, V end, E weight) {
		// TODO Auto-generated method stub
		int startIdx = mVertexList.indexOf(start);
		int endIdx = mVertexList.indexOf(end);
		
		_addEdge(startIdx, endIdx, weight);
		_addEdge(endIdx, startIdx, weight);
	}

	private void _addEdge(int starti, int endi, E weight) {
		// TODO Auto-generated method stub
		ArrayList<E> row = mMatrix.get(starti);
		while (row.size() < mMatrix.size()) {
			row.add(null);
		}
		
		row.set(endi, weight);
	}

	@Override
	public Iterator<V> adjacent(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Edge<V, E>> incident(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdjacent(V start, V end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int orderIn(V v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int orderOut(V v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVertexSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
