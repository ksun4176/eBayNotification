import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Gui extends JPanel{ 
	// private JLayeredPane layeredPane;
	// private JLayeredPane layeredPane2;
  private static final int WIDTH = 175;
  private static final int HEIGHT_TOP = 215;
  private static final int HEIGHT_BOT = 225;
  private static final Color BG_COLOR = Color.CYAN;

  private String search;
  private String email;
  private JLabel inv_search_inp = new JLabel("Enter a search query");
  private JLabel inv_email_inp = new JLabel("Enter a valid email address");
  private boolean valid_search = true;
  private boolean valid_email = true;
  ImageIcon submitButtonIcon = new ImageIcon("imgs/submit.png");
	private JPanel top;
	private JPanel bot;
  private JTextField search_field;
  private JTextField email_field;
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
    search_field = new JTextField(15);
    email_field = new JTextField(15); 
    JButton submit = new JButton("Submit");
    submit.setIcon(resizeIcon(submitButtonIcon, 3));
    submit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        submitButtonPressed();
      }
    });
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

  public void submitButtonPressed(){
    // update search and email string, change this to update only when valid 
    search = search_field.getText();
    email = email_field.getText();


    // rudimentary input check
    // empty search
    if (search_field.getText().equals("")){
      // add label only if it doesnt exist before 
      if (valid_search){
        top.add(inv_search_inp); // how to dynamically remove?
        valid_search = false;
        top.revalidate();
        top.repaint();
      }
    }else{
      //VALID INPUT
      valid_search = true;
      top.remove(inv_search_inp);
      top.validate();
      top.repaint();
    }
    // email does not contain @
    if (!email_field.getText().contains("@")){
      if (valid_email){
        top.add(inv_email_inp);
        valid_email = false;
        top.revalidate();
        top.repaint();
      }
    }else{
      // VALID INPUT
      valid_email = true;
      top.remove(inv_email_inp);
      top.validate();
      top.repaint(); 
    }
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