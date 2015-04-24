package dgraphe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class UndirectGraphMatrix<V, E extends Comparable<E>> implements
		Graph<V, E> {
	final ArrayList<V> mVertexList = new ArrayList<V>();
	final ArrayList<ArrayList<E>> mMatrix = new ArrayList<ArrayList<E>>();

	@Override
	public void addVertex(V vertex) {
		if (mVertexList.contains(vertex)) {
			throw new IllegalStateException("already added");
		}

		mVertexList.add(vertex);
		mMatrix.add(new ArrayList<E>());
	}

	@Override
	public void addEdge(V start, V end, E weight) {
		int startIdx = mVertexList.indexOf(start);
		if (startIdx < 0) {
			throw new IllegalStateException("invalid vertex");
		}
		
		int endIdx = mVertexList.indexOf(end);
		if (endIdx < 0) {
			throw new IllegalStateException("invalid vertex");
		}
		
		_addEdge(startIdx, endIdx, weight);
		_addEdge(endIdx, startIdx, weight);
	}

	protected void _addEdge(int starti, int endi, E weight) {
		ArrayList<E> row = mMatrix.get(starti);
		while (row.size() < mMatrix.size()) {
			row.add(null);
		}

		row.set(endi, weight);
	}

	@Override
	public Iterator<V> adjacent(V vertex) {
		ArrayList<V> r = new ArrayList<V>();
		
		int rowI = mVertexList.indexOf(vertex);
		ArrayList<E> row = mMatrix.get(rowI);
		
		for (int i=0; i < row.size(); ++i) {
			if (Objects.isNull(row.get(i)) == false) {
				r.add(mVertexList.get(i));
			}
		}
		
		return r.iterator();
	}

	@Override
	public Iterator<Edge<V, E>> incident(V start) {
		ArrayList<Edge<V, E>> r = new ArrayList<>();
		
		ArrayList<E> row = mMatrix.get(mVertexList.indexOf(start));
		
		for (int i=0; i < row.size(); ++i) {
			if (row.get(i) != null) {
				r.add(new Edge<V, E>(start, mVertexList.get(i), row.get(i)));
			}
		}
		
		return r.iterator();
	}

	@Override
	public boolean isAdjacent(V start, V end) {
		int rowI = mVertexList.indexOf(start);
		int colI = mVertexList.indexOf(end);
		
		if (rowI < 0 || colI < 0 || rowI >= mMatrix.size() || colI >= mMatrix.get(rowI).size()) {
			throw new IllegalStateException("inAdjacent function error");
		}
		
		return Objects.isNull(mMatrix.get(rowI).get(colI)) == false;
	}

	@Override
	public int orderIn(V v) {
	
		return orderOut(v);
	}

	@Override
	public int orderOut(V v) {
		int cnt = 0;
		
		Iterator<V> vertexes = adjacent(v);
		while (vertexes.hasNext()) {
			vertexes.next();
			++cnt;
		}
		return cnt;
	}

	@Override
	public int getVertexSize() {
		return 0;
	}

}
