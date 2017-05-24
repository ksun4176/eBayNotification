import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gui extends JPanel{ 
	// private JLayeredPane layeredPane;
	// private JLayeredPane layeredPane2;
  private static final int WIDTH = 175;
  private static final int HEIGHT_TOP = 225;
  private static final int HEIGHT_BOT = 225;
  private static final Color BG_COLOR = Color.CYAN;
  ImageIcon submitButtonIcon = new ImageIcon("imgs/submit.png");
	private JPanel top;
	private JPanel bot;
	public Gui(){
    top = new JPanel(new GridLayout(0,1));
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
    top.setPreferredSize(new Dimension(WIDTH, HEIGHT_TOP));
    top.setBorder(BorderFactory.createTitledBorder("top"));
    top.setBackground(BG_COLOR);
    // Create the label + text fields
    JTextField search_field = new JTextField(15);
    JTextField email_field = new JTextField(15); 
    JButton submit = new JButton("Submit");
    submit.setIcon(resizeIcon(submitButtonIcon, 3));
    // Add items to the top panel
    top.add(new JLabel("Search: "));
    top.add(search_field);
    top.add(new JLabel("E-mail: "));
    top.add(email_field);
    top.add(submit);
  }
  private void createBotWindow(){
    bot.setPreferredSize(new Dimension(WIDTH, HEIGHT_BOT));
    bot.setBorder(BorderFactory.createTitledBorder("bot"));
    // bot.setBackground(BG_COLOR);
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


  // method to resize ImageIcon into JButton
  private static Icon resizeIcon(ImageIcon icon, int factor) {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(img.getWidth(null)/factor, img.getHeight(null)/factor,  java.awt.Image.SCALE_SMOOTH);  
    return new ImageIcon(resizedImage);
  }
}