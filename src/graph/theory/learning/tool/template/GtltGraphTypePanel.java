package graph.theory.learning.tool.template;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GtltGraphTypePanel extends JPanel {

  private JLabel graphTypeLabel;
  private JCheckBox derectedGraphCheckBox;
  private JCheckBox underectedGraphCheckBox;
  private JCheckBox directedToUndirectedCheckBox;
  private JCheckBox undirectedToDirectedCheckBox;


  /**
   * Create the panel.
   */
  public GtltGraphTypePanel() {

    setBorder(BorderFactory.createTitledBorder("Graph Type"));
    setLayout(new GridLayout(3, 2, 5, 5));

    graphTypeLabel = new JLabel("First select a Graph Type");

    derectedGraphCheckBox = new JCheckBox("Directed Graph");
    derectedGraphCheckBox.setName("DirectedGraph");

    underectedGraphCheckBox = new JCheckBox("Undirected Graph");
    underectedGraphCheckBox.setName("UndirectedGraph");

    directedToUndirectedCheckBox = new JCheckBox("Directed -> Undirected");
    directedToUndirectedCheckBox.setName("DirectedToUndirected");
    directedToUndirectedCheckBox.setEnabled(false);

    undirectedToDirectedCheckBox = new JCheckBox("Undirected -> Directed");
    undirectedToDirectedCheckBox.setName("UndirectedToDirected");
    undirectedToDirectedCheckBox.setEnabled(false);

    add(derectedGraphCheckBox);
    add(underectedGraphCheckBox);
    add(directedToUndirectedCheckBox);
    add(undirectedToDirectedCheckBox);
    add(graphTypeLabel);

  }

  public JLabel getGraphTypeLabel() {
    return graphTypeLabel;
  }

  public JCheckBox getDerectedGraphCheckBox() {
    return derectedGraphCheckBox;
  }

  public JCheckBox getUnderectedGraphCheckBox() {
    return underectedGraphCheckBox;
  }

  public JCheckBox getDirectedToUndirectedCheckBox() {
    return directedToUndirectedCheckBox;
  }

  public JCheckBox getUndirectedToDirectedCheckBox() {
    return undirectedToDirectedCheckBox;
  }





}
