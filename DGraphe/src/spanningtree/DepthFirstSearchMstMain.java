package spanningtree;

import java.util.Iterator;

import dgraphe.Graph;
import dgraphe.UndirectGraphMatrix;

public class DepthFirstSearchMstMain {

	public static void main(String[] args) {
		Graph<String, Integer> g = new UndirectGraphMatrix<String, Integer> ();
		
		g.addVertex("A");g.addVertex("B");
		g.addVertex("C");g.addVertex("D");
		g.addVertex("E");g.addVertex("F");
		g.addVertex("G");
		
		g.addEdge("A", "B", 1);g.addEdge("A", "C", 1);
		g.addEdge("B", "D", 1);g.addEdge("B", "E", 1);
		g.addEdge("C", "E", 1);g.addEdge("D", "G", 1);
		g.addEdge("E", "G", 1);g.addEdge("G", "F", 1);
		
		
		DepthFirstMst<String, Integer> dfm = new DepthFirstMst<String, Integer>(g, "A", "F");
		dfm.run();
		Iterator<String> path = dfm.path();
		
		while (path.hasNext()) {
			System.out.print(path.next() + "->");
		}
		System.out.println();
	}

}
