package graph.theory.learning.tool.template;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class GtltGraphSearchPanel extends JPanel {
  private JCheckBox bfscheckBox;
  private JCheckBox dfscheckBox;

  private JCheckBox dijkstracheckBox;
  private JCheckBox astarcheckBox;

  /**
   * Create the panel.
   */
  public GtltGraphSearchPanel() {
    TitledBorder titledBorder = BorderFactory.createTitledBorder("Graph Search Algorithm");
    titledBorder.setTitleColor(Color.WHITE);
    setBorder(titledBorder);
    setLayout(new GridLayout(4, 1, 5, 5));

    bfscheckBox = new JCheckBox("Breadth-first Search");
    bfscheckBox.setBackground(Color.LIGHT_GRAY);
    bfscheckBox.setBorder(new EmptyBorder(10, 10, 10, 10));


    dfscheckBox = new JCheckBox("Depth-first Search");
    dfscheckBox.setBackground(Color.LIGHT_GRAY);
    dfscheckBox.setBorder(new EmptyBorder(10, 10, 10, 10));

    dijkstracheckBox = new JCheckBox("Dijkstra's algorithm");
    dijkstracheckBox.setBackground(Color.LIGHT_GRAY);
    dijkstracheckBox.setBorder(new EmptyBorder(10, 10, 10, 10));


    astarcheckBox = new JCheckBox("A* search");
    astarcheckBox.setBackground(Color.LIGHT_GRAY);
    astarcheckBox.setBorder(new EmptyBorder(10, 10, 10, 10));

    add(bfscheckBox);
    add(dfscheckBox);
    add(dijkstracheckBox);
    add(astarcheckBox);
  }

}
