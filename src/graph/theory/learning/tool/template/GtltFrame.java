package graph.theory.learning.tool.template;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import graph.theory.learning.tool.data.Graph;
import java.awt.BorderLayout;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class GtltFrame extends JFrame {
  private JPanel gtltJPanel;
  private JPanel graphDrawingPanel;
  private JPanel gtltGraphPanel;
  private GtltGraphCreationPanel gtltGraphCreationPanel;
  private JPanel gtltGraphSearchPanel;
  private GtltGraphTypePanel gtltGraphTypePanel;
  private GtltMouseDraggedAdapter gtltMouseDraggedAdapter;


  /**
   * Create the frame.
   */
  public GtltFrame() {
    //setForeground(Color.LIGHT_GRAY);
    setBackground(Color.BLUE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 800);
    setLayout(new BorderLayout());
    setTitle("Graph Theory Learning Tool");
    try {
      setIconImage(ImageIO.read(new File("image\\JGEC_logo.png")));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    setResizable(false);

    gtltJPanel = new JPanel();
    gtltJPanel.setLayout(null);

    gtltGraphCreationPanel = new GtltGraphCreationPanel();
    gtltGraphCreationPanel.setBackground(Color.DARK_GRAY);
    //gtltButtonPanel.setPreferredSize(new Dimension(100, 100));
    gtltGraphCreationPanel.setBounds(20, 50, 150, 200);
    //gtltButtonPanel.setAlignmentX(LEFT_ALIGNMENT);

    gtltGraphTypePanel = new GtltGraphTypePanel();
    gtltGraphTypePanel.setBackground(Color.LIGHT_GRAY);
    gtltGraphTypePanel.setBounds(220, 20, 320, 90);


    gtltGraphSearchPanel = new GtltGraphSearchPanel();
    gtltGraphSearchPanel.setBackground(Color.DARK_GRAY);
    gtltGraphSearchPanel.setBounds(20, 270, 150, 150);



    graphDrawingPanel = new JPanel();
    graphDrawingPanel.setLayout(null);
    graphDrawingPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray), "Graph Drawing Area", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
    graphDrawingPanel.setBounds(220, 150, 400, 400);
    graphDrawingPanel.setBackground(Color.lightGray);

    gtltGraphPanel = new GtltGraphPanel(gtltGraphCreationPanel,gtltGraphTypePanel);
    gtltGraphPanel.setBackground(Color.WHITE);
    gtltGraphPanel.setBounds(10, 15, 380, 375);
    graphDrawingPanel.add(gtltGraphPanel);
    //gtltGraphPanel.setPreferredSize(new Dimension(450, 400));
    //gtltMouseDraggedAdapter = new GtltMouseDraggedAdapter(points);
    //gtltGraphPanel.addMouseListener(gtltMouseDraggedAdapter);
    //gtltGraphPanel.addMouseMotionListener(gtltMouseDraggedAdapter);
    //gtltGraphPanel.setLayout(new FlowLayout());


    gtltJPanel.add(gtltGraphCreationPanel);
    gtltJPanel.add(gtltGraphTypePanel);
    gtltJPanel.add(gtltGraphSearchPanel);
    gtltJPanel.add(graphDrawingPanel);
    //setContentPane(gtltButtonPanel);
    //setContentPane(gtltGraphPanel);

    add(gtltJPanel);



  }

}
