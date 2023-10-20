package graph.theory.learning.tool.template;


import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;

import javax.swing.event.MouseInputAdapter;

import graph.theory.learning.tool.data.Point;


public class GtltMouseDraggedAdapter extends MouseInputAdapter{

  private int startX;
  private int startY;

  private int endX;
  private int endY;

  private Point p1;
  private Point p2;

  private List<Point> points;

  public GtltMouseDraggedAdapter() {}
  public GtltMouseDraggedAdapter(List<Point> points) {
    this.points = points;
  }

  @Override
  public void mousePressed(MouseEvent evt) {
     startX = evt.getX();
     startY = evt.getY();
     System.out.println("point is pressed");
     Random r = new Random();
     char c = (char)(points.size()%26 + 'A');
     String name = String.valueOf(c)+String.valueOf(r.nextInt(10));
     p1 = new Point(startX,startY, name);
     points.add(p1);

  }
  @Override
  public void mouseDragged(MouseEvent evt) {
     endX = evt.getX();
     endY = evt.getY();
     //repaint();  // Called back paintComponent()
  }
  @Override
     public void mouseReleased(MouseEvent evt) {
     endX = evt.getX();
     endY = evt.getY();

     for(Point p :points) {
       System.out.println(p.getX() + " "+p.getY());

     }

     //repaint();  // Called back paintComponent()
  }

}
