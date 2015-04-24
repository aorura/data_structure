package dgraphe;

import java.util.Iterator;

public class UndirectGraphMatrixMain {

	public static void main(String[] args) {
		UndirectGraphMatrix<String, Integer> g = new UndirectGraphMatrix<String, Integer>();
		
		g.addVertex("0");g.addVertex("1");
		g.addVertex("2");g.addVertex("3");
		
		g.addEdge("0", "1", 1);g.addEdge("1", "3", 1);
		g.addEdge("2", "1", 1);g.addEdge("2", "3", 1);
		g.addEdge("3", "0", 1);g.addEdge("3", "1", 1);

		System.out.println("" + g.orderIn("1"));
		System.out.println("" + g.isAdjacent("1", "2"));
		System.out.println("" + g.isAdjacent("0", "2"));
		Iterator<Edge<String, Integer>> incidents = g.incident("3");
		incidents.forEachRemaining(e->System.out.println(""+e));
		
		DirectGraphMatrix<String, Integer> dg = new DirectGraphMatrix<String, Integer>();
		dg.addVertex("0");dg.addVertex("1");
		dg.addVertex("2");dg.addVertex("3");
		
		dg.addEdge("0", "1", 1);dg.addEdge("1", "3", 1);
		dg.addEdge("2", "1", 1);dg.addEdge("2", "3", 1);
		dg.addEdge("3", "0", 1);dg.addEdge("3", "1", 1);

		System.out.println("" + dg.orderIn("1"));
		System.out.println("" + dg.isAdjacent("1", "2"));
		System.out.println("" + dg.isAdjacent("0", "2"));
		Iterator<Edge<String, Integer>> incidents2 = dg.incident("3");
		incidents2.forEachRemaining(e->System.out.println(""+e));
	}
}
