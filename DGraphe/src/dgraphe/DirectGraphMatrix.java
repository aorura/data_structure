package dgraphe;

import java.util.ArrayList;
import java.util.Iterator;

public class DirectGraphMatrix<V, E extends Comparable<E>> extends
		UndirectGraphMatrix<V, E> {
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
	}

	@Override
	public int orderIn(V v) {
		int cnt = 0;

		int rowSize = mMatrix.size();
		int colIndex = mVertexList.indexOf(v);
				
		ArrayList<E> row;
		for (int i = 0; i < rowSize; ++i) {
			row = mMatrix.get(i);
			
			if (row.size() < mMatrix.size()) {
				continue;
			}

			if (row.get(colIndex) != null) {
				++cnt;
			}
		}
		
		Iterator<V> vertexes = adjacent(v);
		while (vertexes.hasNext()) {
			vertexes.next();
			++cnt;
		}
		
		return cnt;
	}
}
