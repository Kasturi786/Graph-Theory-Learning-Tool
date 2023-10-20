package graph.theory.learning.tool.template;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.event.MouseInputListener;

import graph.theory.learning.tool.data.ButtonEnable;
import graph.theory.learning.tool.data.CheckBoxEnable;
import graph.theory.learning.tool.data.Edge;
import graph.theory.learning.tool.data.Graph;
import graph.theory.learning.tool.data.Point;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class GtltGraphPanel extends JPanel implements MouseInputListener {
  private Graph oldGraph;

  private List<Point> points;
  private List<Edge> edgesWithWeight;
  private Map<Point,List<Edge>> pointToedge ;

  private GtltGraphCreationPanel graphCreationPanel;
  private GtltGraphTypePanel graphTypePanel;

  private ButtonEnable buttonEnable;
  private CheckBoxEnable checkBoxEnable;

  private int startX;
  private int startY;

  private int endX;
  private int endY;

  private Point p1;
  private Point key;

  private Edge edgeToDelete;

  private RegisterListerner registerListerner;


  /**
   * Create the panel.
   * @param gtltGraphTypePanel
   */
  public GtltGraphPanel(GtltGraphCreationPanel gtltGraphCreationPanel, GtltGraphTypePanel gtltGraphTypePanel){
    this.oldGraph = new Graph();
    this.graphCreationPanel = gtltGraphCreationPanel;
    this.graphTypePanel = gtltGraphTypePanel;
    this.points = oldGraph.getPoints();
    this.pointToedge = oldGraph.getPointToEdge();
    this.edgesWithWeight = oldGraph.getEdges();

    registerListerner = new RegisterListerner(this, graphCreationPanel,graphTypePanel, oldGraph);

    buttonEnable = registerListerner.getButtonEnable();
    checkBoxEnable = registerListerner.getCheckBoxEnable();
    this.addMouseMotionListener(this);
    this.addMouseListener(this);


 }


  @Override
  public void paintComponent(Graphics g) {

     super.paintComponent(g);  // paint parent's background

     // drawRect() uses x, y, width and height instead of (x1,y1) and (x2,y2)
     Graphics2D g2 = (Graphics2D) g;
     for(Point p: pointToedge.keySet()) {

       List<Edge> edges = pointToedge.get(p);
       //System.out.println(edges.size());
       System.out.println(edges);
       g.setColor(Color.BLUE);
       g2.setStroke(new BasicStroke(2));
       g.setFont(new Font("Verdana", Font.BOLD, 20));
       g.drawString(p.getName(), p.getX()-5, p.getY()-5);

       g.setColor(Color.RED);
       g.fillOval(p.getX()-5, p.getY()-5, 10, 10);
       g.setColor(Color.BLACK);
       g.drawOval(p.getX()-5, p.getY()-5, 10, 10);
       //g.drawOval(p.getX(), p.getY(), 10, 10);

       if (edges!=null) {
         for(Edge edge :edges) {
           g.setColor(Color.BLACK);
           g.drawLine(p.getX(), p.getY(), edge.getP2().getX(), edge.getP2().getY());
           g.drawString(String.valueOf(edge.getWeight()), (p.getX()+edge.getP2().getX())/2, (p.getY()+edge.getP2().getY())/2);

           if(!checkBoxEnable.isUndirected())
             drawArrowLine(g,p.getX(), p.getY(), edge.getP2().getX(), edge.getP2().getY(),25,9);


           System.out.println("::::::Inside the repaint start :::::");
           System.out.print("edge = ");
           System.out.println(edge);
           System.out.print("edgeToDelete = ");
           System.out.println(edgeToDelete);
           System.out.println(edge.getP1().getName().equals(edgeToDelete!=null?edgeToDelete.getP1().getName():""));
           System.out.println(edge.getP2().getName().equals(edgeToDelete!=null?edgeToDelete.getP2().getName():""));
           System.out.println("::::::Inside the repaint End:::::");

           if(checkBoxEnable.isUndirected() && edgeToDelete!=null) {
             g.setColor(Color.GREEN);
             Edge edge1 = new Edge(edge.getP2(), edge.getP1(),edge.getWeight());
             if(edge.equals(edgeToDelete) || edge1.equals(edgeToDelete)) {

               g.drawLine(p.getX(), p.getY(), edge.getP2().getX(), edge.getP2().getY());
               //drawArrowLine(g,p.getX(), p.getY(), edge.getP2().getX(), edge.getP2().getY(),25,9);

               g.drawLine( edge.getP2().getX(),edge.getP2().getY(),p.getX(), p.getY() );
               //drawArrowLine(g, edge.getP2().getX(), edge.getP2().getY(),p.getX(), p.getY(),25,9);
             }

           }else if(edgeToDelete!=null && edge.equals(edgeToDelete)) {
             g.setColor(Color.GREEN);
             g.drawLine(p.getX(), p.getY(), edge.getP2().getX(), edge.getP2().getY());
             drawArrowLine(g,p.getX(), p.getY(), edge.getP2().getX(), edge.getP2().getY(),25,9);

           }

         }

       }

     }

    }


  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub

    if(buttonEnable.isRmvVertexEnable() && !pointToedge.keySet().isEmpty() ) {
      System.out.println("Key = "+key);
      for(Edge edge: pointToedge.get(key)) {
        edgesWithWeight.remove(edge);
      }
      pointToedge.remove(key);
      points.remove(key);
      for(Point point: pointToedge.keySet()) {

        List<Edge> edges = pointToedge.get(point);
        List<Edge> filteredges = edges.stream().filter(ex -> ex.getP2().equals(key)).collect(Collectors.toList());
        if(filteredges.size()>0) {
          edges.remove(filteredges.get(0));
          pointToedge.put(point, edges);
          edgesWithWeight.remove(filteredges.get(0));
        }

      }
        System.out.println(points);
    }

    if(buttonEnable.isRmvEdgeBtn() && edgeToDelete!=null) {


      edgesWithWeight.remove(edgeToDelete);

      Point key1 = edgeToDelete.getP1();
      List<Edge> value1 = pointToedge.get(edgeToDelete.getP1());

      if(value1!=null) {
        value1.remove(edgeToDelete);
        pointToedge.put(key1, value1);
      }


      Point key2 = edgeToDelete.getP2();
      List<Edge> value2 = pointToedge.get(edgeToDelete.getP2());
      if(value2!=null && value2.contains(new Edge(key2,key1,edgeToDelete.getWeight()))){
        Edge secondEdgeToDelete = new Edge(key2,key1,edgeToDelete.getWeight());
        value2.remove(secondEdgeToDelete);
        pointToedge.put(key2, value2);
        edgesWithWeight.remove(secondEdgeToDelete);
      }

      edgeToDelete = null;
    }

    repaint();

    registerListerner.disableDeleteNodedButtonWhenNoNode();
    registerListerner.disableDeleteEdgeButtonWhenNoEdge();

  }


  @Override
  public void mousePressed(MouseEvent evt) {

    startX = evt.getX();
    startY = evt.getY();

    if(buttonEnable.isVertexEnable()) {

      System.out.println("point is pressed");
      Random r = new Random();
      char c = (char)(points.size()%26 + 'A');
      String name = String.valueOf(c)+String.valueOf(r.nextInt(10));
      p1 = new Point(startX,startY, name);

      if(points.size()==0) {

        points.add(p1);
        pointToedge.put(p1, new ArrayList<Edge>());

      } else {

        List<Point> circlePoints = points.stream()
                                         .filter(p -> Math.sqrt((startY-p.getY())*(startY-p.getY())+ (startX-p.getX())*(startX-p.getX()))<50)
                                         .collect(Collectors.toList());


          if (circlePoints.isEmpty()) {
            points.add(p1);
            pointToedge.put(p1, new ArrayList<Edge>());
          }

      }

      System.out.println(points);
      repaint();

    }

    if (buttonEnable.isEdgeEnable() || buttonEnable.isRmvVertexEnable()) {

        for(Point p : pointToedge.keySet()) {
          if (Math.abs(startY-p.getY())<=10 && Math.abs(startX-p.getX())<=10 ) {
            key = p;
          }

      }

    }


  }
  @Override
  public void mouseDragged(MouseEvent evt) {
     endX = evt.getX();
     endY = evt.getY();
     repaint();  // Called back paintComponent()
  }

  @Override
  public void mouseReleased(MouseEvent evt) {

    if(buttonEnable.isEdgeEnable()) {

      endX = evt.getX();
      endY = evt.getY();

        for(Point p : pointToedge.keySet()) {
          if (Math.abs(endY-p.getY())<=10 && Math.abs(endX-p.getX())<=10 ) {
            System.out.println(p.getX()+ "v" +p.getY());
            System.out.println(key.getX() +" "+ key.getY());
            System.out.println(pointToedge.get(key));
            if(key.getX()!=p.getX() && key.getY()!=p.getY()) {
              Edge edge = new Edge(key,p,new Random().nextInt(10)+1);
              pointToedge.get(key).add(edge);
              edgesWithWeight.add(edge);
              if(checkBoxEnable.isUndirected()) {
                Edge newedge = new Edge(p,key,edge.getWeight());
                pointToedge.get(p).add(newedge);
                edgesWithWeight.add(newedge);
              }
              key = null;
            }

          }
        }
        repaint();  // Called back paintComponent()

    }


    // repaint();  // Called back paintComponent()
  }


  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
      //repaint();
    registerListerner.disableDeleteNodedButtonWhenNoNode();
    registerListerner.disableDeleteEdgeButtonWhenNoEdge();
  }


  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }


  @Override
  public void mouseMoved(MouseEvent e) {
    // TODO Auto-generated method stub
    // Collection<List<Edge>> collectionOfedgeList = pointToedge.values();

    int x = e.getX();
    int y = e.getY();
    System.out.println("edgesWithWeight start");
    System.out.println(edgesWithWeight.size());
    System.out.println(edgesWithWeight.toString());
    System.out.println("edgesWithWeight end");

    if(buttonEnable.isRmvEdgeBtn()) {

      for(Edge edge: edgesWithWeight) {
        Point p1 = edge.getP1();
        Point p2 = edge.getP2();
        int midX = (p1.getX()+p2.getX())/2;
        int midY = (p1.getY()+p2.getY())/2;

        if(Math.abs(x-midX)<=10 && Math.abs(y-midY)<=10) {
          edgeToDelete = edge;
          System.out.println("::::::Inside the mousemoved start:::::");
          System.out.println(edge);
          System.out.println(edgeToDelete);
          System.out.println("::::::Inside the mousemoved start :::::");
          break;

        }else {
          edgeToDelete = null;
          repaint();
        }
      }
       repaint();
    }


  }

  private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
    int dx = x2 - x1, dy = y2 - y1;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - d, xn = xm, ym = h, yn = -h, x;
    double sin = dy / D, cos = dx / D;

    x = xm*cos - ym*sin + x1;
    ym = xm*sin + ym*cos + y1;
    xm = x;

    x = xn*cos - yn*sin + x1;
    yn = xn*sin + yn*cos + y1;
    xn = x;

    int[] xpoints = {(int) (x2-15*cos), (int) xm, (int) xn};
    int[] ypoints = {(int) (y2-15*sin), (int) ym, (int) yn};

    //g.setColor(Color.LIGHT_GRAY);
    g.fillPolygon(xpoints, ypoints, 3);
}


}
