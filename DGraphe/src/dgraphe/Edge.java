package dgraphe;

public class Edge<V, E> {

	private V start;
	private V end;
	private V weight;

	public Edge(V start, V end, E weight) {
		this.start = start;
		this.end = end;
		this.weight = end;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(" + start + ", " + end + ", " + weight + ")");
		
		return sb.toString();
	}
	
}
