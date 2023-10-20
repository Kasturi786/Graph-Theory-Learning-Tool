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
public class GtltGraphCreationPanel extends JPanel {
  private JCheckBox createGraphCheckBox;

  private JButton addNodeBtn;
  private JButton addEdgeBtn;

  private JButton rmvNodeBtn;
  private JButton rmvEdgeBtn;

  private JButton adjustEdgeWeight;


  /**
   * Create the panel.
   */
  public GtltGraphCreationPanel() {

    TitledBorder titledBorder = BorderFactory.createTitledBorder("Create a Graph");
    titledBorder.setTitleColor(Color.WHITE);
    setBorder(titledBorder);
    setLayout(new GridLayout(6, 1, 5, 5));

    createGraphCheckBox = new JCheckBox("Create Graph");
    createGraphCheckBox.setName("CreateGraph");
    createGraphCheckBox.setBackground(Color.LIGHT_GRAY);
    createGraphCheckBox.setBorder(new EmptyBorder(10, 10, 10, 10));

    addNodeBtn = new JButton("Add Node");
    addNodeBtn.setName("AddNode");
    addNodeBtn.setBackground(Color.LIGHT_GRAY);
    addNodeBtn.setEnabled(false);
    addNodeBtn.setBorder(new EmptyBorder(10, 10, 10, 10));


    addEdgeBtn = new JButton("Add Edge");
    addEdgeBtn.setName("AddEdge");
    addEdgeBtn.setBackground(Color.LIGHT_GRAY);
    addEdgeBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
    addEdgeBtn.setEnabled(false);

    rmvNodeBtn = new JButton("Delete Node");
    rmvNodeBtn.setName("DeleteNode");
    rmvNodeBtn.setBackground(Color.LIGHT_GRAY);
    rmvNodeBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
    rmvNodeBtn.setEnabled(false);


    rmvEdgeBtn = new JButton("Delete Edge");
    rmvEdgeBtn.setName("DeleteEdge");
    rmvEdgeBtn.setBackground(Color.LIGHT_GRAY);
    rmvEdgeBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
    rmvEdgeBtn.setEnabled(false);

    adjustEdgeWeight = new JButton("Adjust Edge Weight");
    adjustEdgeWeight.setName("AdjustEdgeWeight");
    adjustEdgeWeight.setBackground(Color.LIGHT_GRAY);
    adjustEdgeWeight.setBorder(new EmptyBorder(10, 10, 10, 10));
    adjustEdgeWeight.setEnabled(false);


    add(createGraphCheckBox);
    add(addNodeBtn);
    add(addEdgeBtn);
    add(rmvNodeBtn);
    add(rmvEdgeBtn);
    add(adjustEdgeWeight);


  }

  public JButton getAddNodeBtn() {
    return addNodeBtn;
  }

  public JButton getAddEdgeBtn() {
    return addEdgeBtn;
  }

  public JButton getRmvNodeBtn() {
    return rmvNodeBtn;
  }

  public JButton getRmvEdgeBtn() {
    return rmvEdgeBtn;
  }

  public JCheckBox getCreateGraphCheckBox() {
    return createGraphCheckBox;
  }

  public JButton getAdjustEdgeWeight() {
    return adjustEdgeWeight;
  }



}
