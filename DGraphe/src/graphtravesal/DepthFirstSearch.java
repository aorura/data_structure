package graphtravesal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

import dgraphe.Graph;

public class DepthFirstSearch<V, E extends Comparable<E>> implements GraphTraversal<V, E> {

	private Graph<V, E> graph;
	private V start;

	public DepthFirstSearch(Graph<V, E> g, V start) {
		this.graph = g;
		this.start = start;
	}

	@Override
	public V startVertex() {
		
		return this.start;
	}

	@Override
	public Iterator<V> path() {
		
		return mPath.iterator();
	}

	TreeMap<V, Boolean> mVisited = new TreeMap<V, Boolean>();
	ArrayList<V> mPath = new ArrayList<V>();
	
	@Override
	public void run() {
		_run(this.start);
	}
	
	private void _run(V v) {
		mVisited.put(v,  Boolean.TRUE);
		mPath.add(v);
		
		Iterator<V> iter = this.graph.adjacent(v);
		
		while (iter.hasNext()) {
			V w = iter.next();
			Boolean isVisited = mVisited.get(w);
			if (Objects.isNull(isVisited) || Boolean.FALSE.equals(isVisited)) {
				_run(w);
			}
		}
	}

}
