package graph.theory.learning.tool.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

  private List<Point> points;
  private List<Edge> edges;
  private Map<Point, List<Edge>> pointToEdge;

  public Graph() {
    super();
    // TODO Auto-generated constructor stub
    points = new ArrayList<Point>();
    edges = new ArrayList<Edge>();
    pointToEdge = new HashMap<Point, List<Edge>>();
  }

  public List<Point> getPoints() {
    return points;
  }

  public void setPoints(List<Point> points) {
    this.points = points;
  }

  public List<Edge> getEdges() {
    return edges;
  }

  public void setEdges(List<Edge> edges) {
    this.edges = edges;
  }

  public Map<Point, List<Edge>> getPointToEdge() {
    return pointToEdge;
  }

  public void setPointToEdge(Map<Point, List<Edge>> pointToEdge) {
    this.pointToEdge = pointToEdge;
  }



}
