package graph.theory.learning.tool.template;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import graph.theory.learning.tool.algo.DirectedToUndirected;
import graph.theory.learning.tool.algo.UndirectedToDirected;
import graph.theory.learning.tool.data.ButtonEnable;
import graph.theory.learning.tool.data.CheckBoxEnable;
import graph.theory.learning.tool.data.Graph;

public class GtltCheckBoxActionListener implements ActionListener{
  private Graph graph;
  private GtltGraphCreationPanel graphCreationPanel;
  private GtltGraphTypePanel graphTypePanel;
  private CheckBoxEnable checkBoxEnable;
  private ButtonEnable buttonEnable;
  private GtltGraphPanel gtltGraphPanel;

  public GtltCheckBoxActionListener(GtltGraphPanel gtltGraphPanel, GtltGraphCreationPanel graphCreationPanel, GtltGraphTypePanel graphTypePanel, CheckBoxEnable checkBoxEnable, ButtonEnable buttonEnable, Graph graph) {
    super();
    this.gtltGraphPanel = gtltGraphPanel;
    this.graphTypePanel = graphTypePanel;
    this.graphCreationPanel = graphCreationPanel;
    this.checkBoxEnable = checkBoxEnable;
    this.buttonEnable = buttonEnable;

    this.graph = graph;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    AbstractButton absB = (AbstractButton) e.getSource();
    String name =absB.getName();
    System.out.println(name);
    boolean slct = absB.getModel().isSelected();
    System.out.println(slct);
    boolean isDirected = graphTypePanel.getDerectedGraphCheckBox().isSelected();
    boolean isUndirected = graphTypePanel.getUnderectedGraphCheckBox().isSelected();
    System.out.println("isDirected="+isDirected);
    System.out.println("isUndirected="+isUndirected);
    switch(name) {
    case "CreateGraph":
      if(slct) {

        if(isDirected || isUndirected) {
          enableButton();

        } else {
         System.out.println("First select the graph Type");
         absB.getModel().setSelected(false);
         disableButton();
        }

      }else{disableButton();}

      break;
    case "DirectedGraph":
      if(slct) {
        graphTypePanel.getDerectedGraphCheckBox().setEnabled(false);

        graphTypePanel.getUnderectedGraphCheckBox().setSelected(false);
        graphTypePanel.getUnderectedGraphCheckBox().setEnabled(false);


        graphTypePanel.getDirectedToUndirectedCheckBox().setEnabled(true);
        graphTypePanel.getDirectedToUndirectedCheckBox().setSelected(false);

        checkBoxEnable.setDirected(true);
        checkBoxEnable.setUndirected(false);
      }else if(!isUndirected) {
        graphTypePanel.getUnderectedGraphCheckBox().setEnabled(true);

        graphTypePanel.getDirectedToUndirectedCheckBox().setEnabled(false);
        graphTypePanel.getDirectedToUndirectedCheckBox().setSelected(false);

        graphCreationPanel.getCreateGraphCheckBox().setSelected(false);
        disableButton();
      }
      break;
    case "UndirectedGraph":
      if(slct) {
        graphTypePanel.getUnderectedGraphCheckBox().setEnabled(false);

        graphTypePanel.getDerectedGraphCheckBox().setSelected(false);
        graphTypePanel.getDerectedGraphCheckBox().setEnabled(false);

        graphTypePanel.getUndirectedToDirectedCheckBox().setEnabled(true);
        graphTypePanel.getUndirectedToDirectedCheckBox().setSelected(false);

        checkBoxEnable.setDirected(false);
        checkBoxEnable.setUndirected(true);

      }else if(!isDirected) {
        graphCreationPanel.getCreateGraphCheckBox().setSelected(false);
        disableButton();
      }
      break;
    case "DirectedToUndirected":
      graphTypePanel.getDerectedGraphCheckBox().setSelected(false);

      graphTypePanel.getUnderectedGraphCheckBox().setSelected(true);
      graphTypePanel.getUnderectedGraphCheckBox().setEnabled(false);

      graphTypePanel.getUndirectedToDirectedCheckBox().setEnabled(true);

      graphTypePanel.getDirectedToUndirectedCheckBox().setSelected(false);
      graphTypePanel.getDirectedToUndirectedCheckBox().setEnabled(false);

      checkBoxEnable.setDirected(false);
      checkBoxEnable.setUndirected(true);
      DirectedToUndirected directedToUndirected = new DirectedToUndirected(graph);
      directedToUndirected.directedToUndirected();
      gtltGraphPanel.repaint();
      break;
    case "UndirectedToDirected":
      graphTypePanel.getUnderectedGraphCheckBox().setSelected(false);

      graphTypePanel.getDerectedGraphCheckBox().setSelected(true);
      graphTypePanel.getDerectedGraphCheckBox().setEnabled(false);

      graphTypePanel.getDirectedToUndirectedCheckBox().setEnabled(true);

      graphTypePanel.getUndirectedToDirectedCheckBox().setSelected(false);
      graphTypePanel.getUndirectedToDirectedCheckBox().setEnabled(false);

      checkBoxEnable.setDirected(true);
      checkBoxEnable.setUndirected(false);
      UndirectedToDirected undirectedToDirected = new UndirectedToDirected(graph);
      undirectedToDirected.undirectedToDirected();
      gtltGraphPanel.repaint();
      break;

    }



  }

  private void disableButton() {
    // TODO Auto-generated method stub
    graphCreationPanel.getAddNodeBtn().setEnabled(false);
    graphCreationPanel.getAddEdgeBtn().setEnabled(false);
    graphCreationPanel.getRmvNodeBtn().setEnabled(false);
    graphCreationPanel.getRmvEdgeBtn().setEnabled(false);
    graphCreationPanel.getAdjustEdgeWeight().setEnabled(false);

    graphCreationPanel.getAddNodeBtn().setBackground(Color.lightGray);
    graphCreationPanel.getAddEdgeBtn().setBackground(Color.lightGray);
    graphCreationPanel.getRmvNodeBtn().setBackground(Color.lightGray);
    graphCreationPanel.getRmvEdgeBtn().setBackground(Color.lightGray);
    graphCreationPanel.getAdjustEdgeWeight().setBackground(Color.lightGray);

    buttonEnable.setVertexEnable(false);
    buttonEnable.setEdgeEnable(false);
    buttonEnable.setRmvVertexEnable(false);
    buttonEnable.setRmvEdgeBtn(false);



  }

  private void enableButton() {
    // TODO Auto-generated method stub
    graphCreationPanel.getAddNodeBtn().setEnabled(true);
    graphCreationPanel.getAddEdgeBtn().setEnabled(true);
    graphCreationPanel.getRmvNodeBtn().setEnabled(true);
    graphCreationPanel.getRmvEdgeBtn().setEnabled(true);
    graphCreationPanel.getAdjustEdgeWeight().setEnabled(true);
  }

}
