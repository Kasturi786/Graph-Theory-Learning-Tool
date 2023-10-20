package graph.theory.learning.tool.main;

import java.awt.EventQueue;

import graph.theory.learning.tool.template.GtltFrame;

public class GtltMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          GtltFrame frame = new GtltFrame();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

  }

}
