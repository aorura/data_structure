package dgraphe;

import java.util.Iterator;

public interface Graph<V, E extends Comparable<E>> {
	void addVertex(V vertex);
	void addEdge(V start, V end, E weight);
	
	Iterator<V> adjacent(V vertex);
	Iterator<Edge<V, E>> incident(V vertex);
	boolean isAdjacent(V start, V end);
	int orderIn(V v);
	int orderOut(V v);
	
	int getVertexSize();
}
