package com.ds.graph.mst;

import java.util.List;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

public class MainGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedSparseGraph<String, Integer> g = new DirectedSparseGraph<String, Integer>();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addEdge(5, "A", "B");
		g.addEdge(4, "B", "C");
		g.addEdge(9, "A", "C");
		
		System.out.println(g.toString());
		
		DijkstraShortestPath<String, Integer> dsp = new DijkstraShortestPath<String, Integer>(g);
		List<Integer> path = dsp.getPath("A", "C");
		System.out.println(path);
	}

}
