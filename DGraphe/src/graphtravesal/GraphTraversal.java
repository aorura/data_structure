package graphtravesal;

import java.util.Iterator;

public interface GraphTraversal<V, E> {
	public V startVertex();
	Iterator<V> path();
	public void run();
}
