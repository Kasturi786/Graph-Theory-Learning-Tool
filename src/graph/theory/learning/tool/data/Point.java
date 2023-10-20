package graph.theory.learning.tool.data;

import java.util.Objects;

public class Point implements Comparable<Point> {

  private int x;
  private int y;
  private String name;

  public Point() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Point(int x, int y, String name) {
    super();
    this.x = x;
    this.y = y;
    this.name = name;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, x, y);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Point other = (Point) obj;
    return Objects.equals(name, other.name) && x == other.x && y == other.y;
  }

  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + ", name=" + name + "]";
  }

  @Override
  public int compareTo(Point o) {
    // TODO Auto-generated method stub
    return 0;
  }








}
