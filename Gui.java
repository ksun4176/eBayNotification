import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JPanel{ 
	// private JLayeredPane layeredPane;
	// private JLayeredPane layeredPane2;
	private JPanel top;
	private JPanel bot;
	public Gui(){
    top = new JPanel();
    bot = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    createTopWindow();
    createBotWindow();
		// layeredPane = new JLayeredPane();
  //       layeredPane.setPreferredSize(new Dimension(300, 310));
  //       layeredPane.setBorder(BorderFactory.createTitledBorder(
  //                                   "Move the Mouse to Move Duke"));
  //       layeredPane2 = new JLayeredPane();
  //       layeredPane2.setPreferredSize(new Dimension(300, 310));
  //       layeredPane2.setBorder(BorderFactory.createTitledBorder(
  //                                   "Move the Mouse to Move Duke"));
		// add(layeredPane);
		// add(layeredPane2);
		add(top);
		add(bot);
	}
  private void createTopWindow(){
    top.setPreferredSize(new Dimension(400,200));
    top.setBorder(BorderFactory.createTitledBorder("top"));
  }
  private void createBotWindow(){
    bot.setPreferredSize(new Dimension(500,500));
    bot.setBorder(BorderFactory.createTitledBorder("bot"));
  }
	private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("eBay Notification");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new Gui();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
  public static void main(String[] args) {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              createAndShowGUI();
          }
      });
  }
}