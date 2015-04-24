package dgraphe;

import java.util.Iterator;

public class UndirectGraphMatrixMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectGraphMatrix<String, Integer> g = new UndirectGraphMatrix();
		
		g.addVertex("0");g.addVertex("1");
		g.addVertex("2");g.addVertex("3");
		
		g.addEdge("0", "1", 1);g.addEdge("1", "3", 1);
		g.addEdge("2", "1", 1);g.addEdge("2", "3", 1);
		g.addEdge("3", "0", 1);g.addEdge("3", "1", 1);

		System.out.println("" + g.orderIn("1"));
		System.out.println("" + g.isAdjacent("1", "2"));
		Iterator<Edge<String, Integer>> incidents = g.incident("3");
		incidents.forEachRemaining(e->System.out.println(""+e));
	}

}
