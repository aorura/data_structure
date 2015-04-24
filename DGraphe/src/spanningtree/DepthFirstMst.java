package spanningtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import dgraphe.Edge;
import dgraphe.Graph;

public class DepthFirstMst<V, E extends Comparable<E>> {

	private Graph<V, E> mGraph;
	private V mStart;
	private V mEnd;

	public DepthFirstMst(Graph<V, E> g, V start, V end) {
		this.mGraph = g;
		this.mStart = start;
		this.mEnd = end;
	}

	public void run() {
		_run(this.mStart);
	}

	TreeMap<V, Boolean> mVisited = new TreeMap<V, Boolean>();
	ArrayList<V> mPath = new ArrayList<V>();

	private boolean _run(V v) {
		mVisited.put(v, Boolean.TRUE);
		mPath.add(v);
		
		if (this.mEnd.equals(v) == true) {
			return true;
		}

		Iterator<Edge<V,E>> iter = this.mGraph.incident(v);
		TreeMap<E, V> ts = new TreeMap<E, V>();

		while (iter.hasNext()) {
			 Edge<V, E> e = iter.next();
			Boolean isVisited = mVisited.get(e.end);
			if (Objects.isNull(isVisited) || Boolean.FALSE.equals(isVisited)) {
				ts.put(e.weight, e.end);
			}
		}
		
		boolean r = false;
		Set<E> sortedWeights = ts.keySet();
		for (E e : sortedWeights) {
			if (r = _run(ts.get(e)) == true) {
				break;
			}
		}
		
		return r;
	}

	public Iterator<V> path() {

		return mPath.iterator();
	}

}
