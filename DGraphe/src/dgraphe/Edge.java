package dgraphe;

public class Edge<V, E> {

	public V start;
	public V end;
	public E weight;

	public Edge(V start, V end, E weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(" + start + ", " + end + ", " + weight + ")");
		
		return sb.toString();
	}
	
}
