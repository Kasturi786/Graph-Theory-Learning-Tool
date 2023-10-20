package graph.theory.learning.tool.template;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import graph.theory.learning.tool.data.ButtonEnable;
import graph.theory.learning.tool.data.CheckBoxEnable;
import graph.theory.learning.tool.data.Graph;

public class RegisterListerner {

  private Graph graph;
  private GtltGraphCreationPanel graphCreationPanel;
  private GtltGraphTypePanel graphTypePanel;
  private GtltGraphPanel gtltGraphPanel;

  private ButtonEnable buttonEnable;
  private CheckBoxEnable checkBoxEnable;

  private JButton addNodeBtn;
  private JButton addEdgeBtn;
  private JButton rmvNodeBtn;
  private JButton rmvEdgeBtn;
  private JButton adjustEdgeWeight;

  private JCheckBox directedGraphchkBox;
  private JCheckBox unDirectedGraphchkBox;
  private JCheckBox createGraphchkBox;
  private JCheckBox directedToUndirectedchkBox;
  private JCheckBox undirectedToDirectedchkBox;

  public RegisterListerner(GtltGraphPanel gtltGraphPanel, GtltGraphCreationPanel graphCreationPanel, GtltGraphTypePanel graphTypePanel, Graph graph) {
    super();
    this.gtltGraphPanel = gtltGraphPanel;
    this.graphCreationPanel = graphCreationPanel;
    this.graphTypePanel = graphTypePanel;
    this.graph = graph;

    buttonEnable = new ButtonEnable();
    ActionListener btnListener = new GtltButtonActionListener(gtltGraphPanel,graphCreationPanel,buttonEnable, graph);
    checkBoxEnable = new CheckBoxEnable();
    ActionListener chkBoxListener = new GtltCheckBoxActionListener(gtltGraphPanel,graphCreationPanel, graphTypePanel,checkBoxEnable, buttonEnable, graph);

    addNodeBtn = graphCreationPanel.getAddNodeBtn();
    addEdgeBtn = graphCreationPanel.getAddEdgeBtn();
    rmvNodeBtn = graphCreationPanel.getRmvNodeBtn();
    rmvEdgeBtn = graphCreationPanel.getRmvEdgeBtn();
    adjustEdgeWeight = graphCreationPanel.getAdjustEdgeWeight();


    createGraphchkBox = graphCreationPanel.getCreateGraphCheckBox();
    directedGraphchkBox = graphTypePanel.getDerectedGraphCheckBox();
    unDirectedGraphchkBox = graphTypePanel.getUnderectedGraphCheckBox();
    directedToUndirectedchkBox = graphTypePanel.getDirectedToUndirectedCheckBox();
    undirectedToDirectedchkBox = graphTypePanel.getUndirectedToDirectedCheckBox();

    registerActionListener(btnListener,chkBoxListener );
  }

  private void registerActionListener(ActionListener btnListener, ActionListener chkBoxListener) {

    addNodeBtn.addActionListener(btnListener);
    addEdgeBtn.addActionListener(btnListener);
    rmvNodeBtn.addActionListener(btnListener);
    rmvEdgeBtn.addActionListener(btnListener);
    adjustEdgeWeight.addActionListener(btnListener);

    createGraphchkBox.addActionListener(chkBoxListener);
    directedGraphchkBox.addActionListener(chkBoxListener);
    unDirectedGraphchkBox.addActionListener(chkBoxListener);

    directedToUndirectedchkBox.addActionListener(chkBoxListener);
    undirectedToDirectedchkBox.addActionListener(chkBoxListener);

  }

  public ButtonEnable getButtonEnable() {
    return buttonEnable;
  }

  public CheckBoxEnable getCheckBoxEnable() {
    return checkBoxEnable;
  }

  public void disableDeleteNodedButtonWhenNoNode() {
    if(graph.getPoints().isEmpty()) {

      if(buttonEnable.isRmvVertexEnable()) {
        buttonEnable.setRmvVertexEnable(false);
        rmvNodeBtn.setBackground(Color.LIGHT_GRAY);
      }
      if(buttonEnable.isRmvEdgeBtn()) {
        buttonEnable.setRmvEdgeBtn(false);
        rmvEdgeBtn.setBackground(Color.LIGHT_GRAY);
      }

    }
  }

  public void disableDeleteEdgeButtonWhenNoEdge() {
    if(graph.getEdges().isEmpty()) {

      if(buttonEnable.isRmvEdgeBtn()) {
        buttonEnable.setRmvEdgeBtn(false);
        rmvEdgeBtn.setBackground(Color.LIGHT_GRAY);
      }

    }
  }







}
