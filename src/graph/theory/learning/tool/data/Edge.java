package graph.theory.learning.tool.data;

import java.util.Objects;

public class Edge {

  private Point p1;
  private Point p2;
  private int weight;

  public Edge() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Edge(Point p1, Point p2, int weight) {
    super();
    this.p1 = p1;
    this.p2 = p2;
    this.weight = weight;
  }

  public Point getP1() {
    return p1;
  }
  public void setP1(Point p1) {
    this.p1 = p1;
  }
  public Point getP2() {
    return p2;
  }
  public void setP2(Point p2) {
    this.p2 = p2;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(p1, p2, weight);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Edge other = (Edge) obj;
    return Objects.equals(p1, other.p1) && Objects.equals(p2, other.p2) && weight == other.weight;
  }

  @Override
  public String toString() {
    return "Edge [p1=" + p1 + ", p2=" + p2 + ", weight=" + weight + "]";
  }



}
