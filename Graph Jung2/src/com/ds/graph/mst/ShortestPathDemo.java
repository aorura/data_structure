/*
 * Created on Jan 2 2004, JUNG Team
 * Modified on Jul 8 2014, sanghyuck.na@lge.com, add Dijkstra algorithm
 */
package com.ds.graph.mst;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.generators.random.EppsteinPowerLawGenerator;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.shortestpath.BFSDistanceLabeler;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.Pair;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;

/**
 * Demonstrates use of the shortest path algorithm and visualization of the
 * results.
 * 
 * @author danyelf, sanghyuck.na
 */
public class ShortestPathDemo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7526217664458188502L;

	/**
	 * Starting vertex
	 */
	private String mFrom;

	/**
	 * Ending vertex
	 */
	private String mTo;
	private Graph<String, MyEdge> mGraph;
	private Set<String> mPred;

	private JComboBox<String> mAlgorithm;

	public ShortestPathDemo() {

		this.mGraph = getGraph();
		setBackground(Color.WHITE);
		// show graph
		final Layout<String, MyEdge> layout = new FRLayout<String, MyEdge>(
				mGraph);
		final VisualizationViewer<String, MyEdge> vv = new VisualizationViewer<String, MyEdge>(
				layout);
		vv.setBackground(Color.WHITE);

		vv.getRenderContext().setVertexDrawPaintTransformer(
				new MyVertexDrawPaintFunction<String>());
		vv.getRenderContext().setVertexFillPaintTransformer(
				new MyVertexFillPaintFunction<String>());
		vv.getRenderContext().setEdgeDrawPaintTransformer(
				new MyEdgePaintFunction());
		vv.getRenderContext().setEdgeStrokeTransformer(
				new MyEdgeStrokeFunction());

		vv.getRenderContext().setVertexLabelTransformer(
				new ToStringLabeller<String>());
		vv.setGraphMouse(new DefaultModalGraphMouse<String, MyEdge>());
		vv.addPostRenderPaintable(new VisualizationViewer.Paintable() {

			public boolean useTransform() {
				return true;
			}

			public void paint(Graphics g) {
				if (mPred == null)
					return;

				// for all edges, paint edges that are in shortest path
				for (MyEdge e : layout.getGraph().getEdges()) {

					if (isBlessed(e)) {
						String v1 = mGraph.getEndpoints(e).getFirst();
						String v2 = mGraph.getEndpoints(e).getSecond();
						Point2D p1 = layout.transform(v1);
						Point2D p2 = layout.transform(v2);
						p1 = vv.getRenderContext().getMultiLayerTransformer()
								.transform(Layer.LAYOUT, p1);
						p2 = vv.getRenderContext().getMultiLayerTransformer()
								.transform(Layer.LAYOUT, p2);
						Renderer<String, MyEdge> renderer = vv.getRenderer();
						renderer.renderEdge(vv.getRenderContext(), layout, e);
					}
				}
			}
		});

		setLayout(new BorderLayout());
		add(vv, BorderLayout.CENTER);
		// set up controls
		add(setUpControls(), BorderLayout.SOUTH);
	}

	boolean isBlessed(MyEdge e) {
		Pair<String> endpoints = mGraph.getEndpoints(e);
		String v1 = endpoints.getFirst();
		String v2 = endpoints.getSecond();
		return v1.equals(v2) == false && mPred.contains(v1)
				&& mPred.contains(v2);
	}

	/**
	 * @author danyelf
	 */
	public class MyEdgePaintFunction implements Transformer<MyEdge, Paint> {

		public Paint transform(MyEdge e) {
			if (mPred == null || mPred.size() == 0)
				return Color.BLACK;
			if (isBlessed(e)) {
				return new Color(0.0f, 0.0f, 1.0f, 0.5f);// Color.BLUE;
			} else {
				return Color.LIGHT_GRAY;
			}
		}
	}

	public class MyEdgeStrokeFunction implements Transformer<MyEdge, Stroke> {
		protected final Stroke THIN = new BasicStroke(1);
		protected final Stroke THICK = new BasicStroke(1);

		public Stroke transform(MyEdge e) {
			if (mPred == null || mPred.size() == 0)
				return THIN;
			if (isBlessed(e)) {
				return THICK;
			} else
				return THIN;
		}

	}

	/**
	 * @author danyelf
	 */
	public class MyVertexDrawPaintFunction<V> implements Transformer<V, Paint> {

		public Paint transform(V v) {
			return Color.black;
		}

	}

	public class MyVertexFillPaintFunction<V> implements Transformer<V, Paint> {

		public Paint transform(V v) {
			if (v == mFrom) {
				return Color.BLUE;
			}
			if (v == mTo) {
				return Color.BLUE;
			}
			if (mPred == null) {
				return Color.LIGHT_GRAY;
			} else {
				if (mPred.contains(v)) {
					return Color.RED;
				} else {
					return Color.LIGHT_GRAY;
				}
			}
		}

	}

	/**
	 *  
	 */
	private JPanel setUpControls() {
		JPanel jp = new JPanel();
		jp.setBackground(Color.WHITE);
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		jp.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		jp.add(new JLabel(
				"Select a pair of vertices for which a shortest path will be displayed"));
		JPanel jp2 = new JPanel();
		jp2.add(new JLabel("Algorithm"));
		jp2.add(mAlgorithm = getSelectionBoxForAlgorithm());

		jp2.add(new JLabel(", Vertex from"));
		jp2.add(getSelectionBox(true));
		jp2.add(new JLabel("to"));
		jp2.add(getSelectionBox(false));

		jp.add(jp2);
		return jp;
	}

	private JComboBox<String> getSelectionBoxForAlgorithm() {
		String[] array = new String[] { "BFS", "Dijkstra" };
		final JComboBox<String> choices = new JComboBox<String>(array);
		choices.setSelectedIndex(0);
		choices.setBackground(Color.WHITE);

		choices.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String v = (String) choices.getSelectedItem();
				if ("BFS".equals(v)) {
					drawBsfSpanningTree();
				} else {
					drawShortestAsDirectra();
				}

				repaint();
			}
		});

		return choices;
	}

	private Component getSelectionBox(final boolean from) {

		Set<String> s = new TreeSet<String>();

		for (String v : mGraph.getVertices()) {
			s.add(v);
		}
		String[] array = new String[s.size()];
		final JComboBox<String> choices = new JComboBox<String>(
				s.toArray(array));
		choices.setSelectedIndex(-1);
		choices.setBackground(Color.WHITE);
		choices.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String v = (String) choices.getSelectedItem();

				if (from) {
					mFrom = v;
				} else {
					mTo = v;
				}

				if ("BFS".equals(mAlgorithm.getSelectedItem().toString())) {
					drawBsfSpanningTree();
				} else {
					drawShortestAsDirectra();
				}

				repaint();
			}
		});
		return choices;
	}

	/**
	 *  
	 */
	protected void drawBsfSpanningTree() {
		if (mFrom == null || mTo == null) {
			return;
		}
		BFSDistanceLabeler<String, MyEdge> bdl = new BFSDistanceLabeler<String, MyEdge>();
		bdl.labelDistances(mGraph, mFrom);
		mPred = new HashSet<String>();

		String v = mTo;
		Set<String> prd = bdl.getPredecessors(v);
		mPred.add(v);
		while (prd != null && prd.size() > 0) {
			Iterator<String> iter = prd.iterator();
			while (iter.hasNext()) {
				v = iter.next();
				mPred.add(v);
				if (v == mFrom)
					return;
			}

			prd = bdl.getPredecessors(v);
		}
	}

	protected void drawShortestAsDirectra() {
		if (mFrom == null || mTo == null) {
			return;
		}

		DijkstraShortestPath<String, MyEdge> alg = new DijkstraShortestPath<String, MyEdge>(
				mGraph);
		mPred = new HashSet<String>();
		mPred.add(mFrom);

		List<MyEdge> l = alg.getPath(mFrom, mTo);

		for (MyEdge myLink : l) {
			mPred.add(mGraph.getEndpoints(myLink).getFirst());
			mPred.add(mGraph.getEndpoints(myLink).getSecond());
		}
		mPred.add(mTo);

	}

	public static void main(String[] s) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().add(new ShortestPathDemo());
		jf.pack();
		jf.setVisible(true);
	}

	/**
	 * @return the graph for this demo
	 */
	/**
	 * @return the graph for this demo
	 */
	Graph<String, MyEdge> getGraph() {

		Graph<String, MyEdge> g = new EppsteinPowerLawGenerator<String, MyEdge>(
				new GraphFactory(), new VertexFactory(), new EdgeFactory(), 26,
				50, 50).create();
		Set<String> removeMe = new HashSet<String>();
		for (String v : g.getVertices()) {
			if (g.degree(v) == 0) {
				removeMe.add(v);
			}
		}
		for (String v : removeMe) {
			g.removeVertex(v);
		}
		return g;
	}

	static class GraphFactory implements Factory<Graph<String, MyEdge>> {
		public Graph<String, MyEdge> create() {
			return new SparseMultigraph<String, MyEdge>();
		}
	}

	static class VertexFactory implements Factory<String> {
		char a = 'a';

		public String create() {
			return Character.toString(a++);
		}

	}

	static class EdgeFactory implements Factory<MyEdge> {
		int count;

		public MyEdge create() {
			return new MyEdge(count++, (int) (Math.random() * 10));
		}

	}

}

class MyVertex {
	private int id;

	public MyVertex(int id) {
		this.id = id;
	}

	public String toString() {
		return "v" + id;
	}
}

class MyEdge {
	private int weight;

	public int getWeight() {
		return weight;
	}

	private int id;

	public MyEdge(int _id, int _weight) {
		this.id = _id;
		this.weight = _weight;
	}

	public String toString() { // Always good for debugging
		return "e" + id;
	}

}
