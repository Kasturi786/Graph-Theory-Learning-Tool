package graph.theory.learning.tool.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import graph.theory.learning.tool.data.Edge;
import graph.theory.learning.tool.data.Graph;
import graph.theory.learning.tool.data.Point;

public class UndirectedToDirected {
  private Graph graph;

  public UndirectedToDirected(Graph graph) {
    super();
    this.graph = graph;
  }


  public void undirectedToDirected() {
     List<Point> points = graph.getPoints();
     List<Edge> edges = graph.getEdges();
     Map<Point,List<Edge>> pointToEdge = graph.getPointToEdge();

     /*
     while(!isStart) {
       start = points.get((new Random().nextInt(points.size())));
       if(pointToEdge.get(start).size()>=2) {
         isStart = true;
       }
     } */

     List<Point> visited = new ArrayList<Point>();
     Queue<Point> queue = new PriorityQueue<Point>();
     List<Edge> allEdges = new ArrayList<Edge>();
     Map<Point,List<Edge>> newPointToEdge = new HashMap<Point,List<Edge>>();
     for(Point point : points) {

       if(!visited.contains(point)) {
         queue.add(point);
         visited.add(point);
       }

       while(!queue.isEmpty()) {

         Point p1 = queue.poll();
         List<Edge> directedEdges = new ArrayList<Edge>();
         List<Edge> toVisit = pointToEdge.get(p1);
         for(Edge edge: toVisit) {
           Point p2 = edge.getP2();
           if(!visited.contains(p2)) {
             queue.add(p2);
             visited.add(p2);
             System.out.println(visited);
             allEdges.add(edge);
             directedEdges.add(edge);
           }
         }

         newPointToEdge.put(p1,directedEdges);


       }

     }

     System.out.println(newPointToEdge);

     for(Point point: newPointToEdge.keySet()) {
       pointToEdge.remove(point);
       pointToEdge.put(point, newPointToEdge.get(point));
     }

     edges.clear();
     for(Edge edge: allEdges) {
       edges.add(edge);
     }

  }

}
