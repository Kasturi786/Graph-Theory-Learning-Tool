package graph.theory.learning.tool.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graph.theory.learning.tool.data.Edge;
import graph.theory.learning.tool.data.Graph;
import graph.theory.learning.tool.data.Point;

public class DirectedToUndirected {
  private Graph graph;

  public DirectedToUndirected(Graph graph) {
    super();
    this.graph = graph;
  }

 public void directedToUndirected() {

   List<Edge> edges = graph.getEdges();
   Map<Point,List<Edge>> pointToEdge=  graph.getPointToEdge();

   List<Edge> newedges = new ArrayList<Edge>();


   for(Edge edge: edges) {
      newedges.add(edge);
      Point p1 = edge.getP1();
      Point p2 = edge.getP2();

      if(pointToEdge.containsKey(p2)) {
        Edge ed = new Edge(p2,p1,edge.getWeight());
        if(!pointToEdge.get(p2).contains(ed)) {
          pointToEdge.get(p2).add(ed);
          newedges.add(ed);
        }
      }

   }

    for(Edge edge:newedges) {
      if(!edges.contains(edge)) {
        edges.add(edge);
      }
    }

 }


}
