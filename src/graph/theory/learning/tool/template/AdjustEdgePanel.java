package graph.theory.learning.tool.template;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdjustEdgePanel extends JPanel {
  private JLabel name1;
  private JLabel name2;
  private JLabel edge;
  private JTextField weight;
  /**
   * Create the panel.
   */
  public AdjustEdgePanel() {
    setLayout(new FlowLayout());
    name1 = new JLabel("a0");
    name1.setBorder(getBorder());
    name2 = new JLabel("b1");
    edge = new JLabel("weight");
    weight = new JTextField("2");

    add(name1);
    add(name2);
    add(edge);
    add(weight);

  }
  public JLabel getName1() {
    return name1;
  }
  public JLabel getName2() {
    return name2;
  }
  public JTextField getWeight() {
    return weight;
  }



}
