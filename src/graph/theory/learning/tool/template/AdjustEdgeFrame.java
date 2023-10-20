package graph.theory.learning.tool.template;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graph.theory.learning.tool.data.Edge;
import graph.theory.learning.tool.data.Graph;
import graph.theory.learning.tool.data.Point;

@SuppressWarnings("serial")
public class AdjustEdgeFrame extends JFrame {
  private List<AdjustEdgePanel> listOfAdjustEdgePanel;
  private JPanel contentPane;
  private JButton save;
  private Graph graph;
  private GtltGraphPanel gtltGraphPanel;

  /**
   * Create the frame.
   * @param gtltGraphPanel
   * @param graph
   */
  public AdjustEdgeFrame(GtltGraphPanel gtltGraphPanel, Graph graph) {
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    //adjustEdgePanel = new AdjustEdgePanel();
    save = new JButton("Save");
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    listOfAdjustEdgePanel = new ArrayList<AdjustEdgePanel>();
    this.graph = graph;
    this.gtltGraphPanel = gtltGraphPanel;
    List<Edge> edges = graph.getEdges();
    Map<Point,List<Edge>> pointToEdge = graph.getPointToEdge();
    for(Edge edge: edges) {
      AdjustEdgePanel panel = new AdjustEdgePanel();
      panel.getName1().setText(edge.getP1().getName());
      panel.getName2().setText(edge.getP2().getName());
      panel.getWeight().setText(String.valueOf(edge.getWeight()));
      listOfAdjustEdgePanel.add(panel);
      contentPane.add(panel);
    }
    //contentPane.add(AdjustEdgePanel);


    contentPane.add(save);

    setContentPane(contentPane);

    save.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(AdjustEdgePanel panel: listOfAdjustEdgePanel) {
          for(Point point : pointToEdge.keySet()) {
            List<Edge> pointEdges = pointToEdge.get(point);

            Optional<Edge> edgeOptional = pointEdges.stream()
                                                    .filter(ed -> isEdgeModified(ed,panel))
                                                    .findFirst();
                                                    //.map(edge ->new Edge(edge.getP1(),edge.getP2(), Integer.valueOf(panel.getWeight().getText())));

             if(edgeOptional.isPresent()) {
               Edge edge = edgeOptional.get();
               Point p1 = edge.getP1();
               Point p2 = edge.getP2();
               Edge newEdge = new Edge(p1,p2, Integer.valueOf(panel.getWeight().getText()));
               edges.remove(edge);
               pointEdges.remove(edge);
               pointEdges.add(newEdge);
               edges.add(newEdge);
             }

          }

          System.out.print(panel.getName1().getText()+ " ");
          System.out.print(panel.getName2().getText()+ " ");
          System.out.print(panel.getWeight().getText()+ " ");
        }

        dispose();
        gtltGraphPanel.repaint();
      }

      private boolean isEdgeModified(Edge edge, AdjustEdgePanel panel) {
        // TODO Auto-generated method stub
        Point p1 = edge.getP1();
        Point p2 = edge.getP2();
        return p1.getName()==panel.getName1().getText() && p2.getName()==panel.getName2().getText();
      }

    });
  }

}
