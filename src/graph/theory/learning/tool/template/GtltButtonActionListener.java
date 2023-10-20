package graph.theory.learning.tool.template;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import graph.theory.learning.tool.data.ButtonEnable;
import graph.theory.learning.tool.data.Graph;

public class GtltButtonActionListener implements  ActionListener{
 private GtltGraphPanel gtltGraphPanel;
 private GtltGraphCreationPanel graphCreationPanel;
 private ButtonEnable buttonEnable;
 private Graph graph;

  public GtltButtonActionListener( GtltGraphPanel gtltGraphPanel, GtltGraphCreationPanel graphCreationPanel, ButtonEnable buttonEnable, Graph oldGraph) {
    super();
    // TODO Auto-generated constructor stub
    this.gtltGraphPanel = gtltGraphPanel;
    this.graphCreationPanel = graphCreationPanel;
    this.buttonEnable = buttonEnable;
    this.graph = oldGraph;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    JButton button = (JButton)e.getSource();
    String name = button.getName();
    System.out.println(name);
    switch(name){
    case "AddNode":
      buttonEnable.setVertexEnable(true);
      buttonEnable.setEdgeEnable(false);
      buttonEnable.setRmvVertexEnable(false);
      buttonEnable.setRmvEdgeBtn(false);

      graphCreationPanel.getAddNodeBtn().setBackground(Color.GREEN);
      graphCreationPanel.getAddEdgeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getRmvNodeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getRmvEdgeBtn().setBackground(Color.LIGHT_GRAY);
      break;
    case "AddEdge":
      buttonEnable.setVertexEnable(false);
      buttonEnable.setEdgeEnable(true);
      buttonEnable.setRmvVertexEnable(false);
      buttonEnable.setRmvEdgeBtn(false);

      graphCreationPanel.getAddNodeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getAddEdgeBtn().setBackground(Color.GREEN);
      graphCreationPanel.getRmvNodeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getRmvEdgeBtn().setBackground(Color.LIGHT_GRAY);
      break;
    case "DeleteNode":
      buttonEnable.setVertexEnable(false);
      buttonEnable.setEdgeEnable(false);
      buttonEnable.setRmvVertexEnable(true);
      buttonEnable.setRmvEdgeBtn(false);

      graphCreationPanel.getAddNodeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getAddEdgeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getRmvNodeBtn().setBackground(Color.GREEN);
      graphCreationPanel.getRmvEdgeBtn().setBackground(Color.LIGHT_GRAY);
      break;
    case "DeleteEdge":
      buttonEnable.setVertexEnable(false);
      buttonEnable.setEdgeEnable(false);
      buttonEnable.setRmvVertexEnable(false);
      buttonEnable.setRmvEdgeBtn(true);

      graphCreationPanel.getAddNodeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getAddEdgeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getRmvNodeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getRmvEdgeBtn().setBackground(Color.GREEN);
      break;
    case "AdjustEdgeWeight":
      buttonEnable.setVertexEnable(false);
      buttonEnable.setEdgeEnable(false);
      buttonEnable.setRmvVertexEnable(false);
      buttonEnable.setRmvEdgeBtn(false);
      graphCreationPanel.getAddNodeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getAddEdgeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getRmvNodeBtn().setBackground(Color.LIGHT_GRAY);
      graphCreationPanel.getRmvEdgeBtn().setBackground(Color.LIGHT_GRAY);

      AdjustEdgeFrame adjustEdgeFrame= new AdjustEdgeFrame(gtltGraphPanel,graph);
      adjustEdgeFrame.setVisible(true);
      break;

    }

  }


}
