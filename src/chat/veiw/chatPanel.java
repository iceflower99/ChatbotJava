package chat.veiw;

import chat.controler.ChatController;
import javax.swing.JPanel;
import javax. swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.*;
import java.awt.Color;

public class chatPanel extends  JPanel
{
   private ChatController baseController;
   private JButton firstButton;
   private JTextField firstTextField;
   private SpringLayout baseLayout;
   
   public chatPanel(ChatController baseController)
   {
	   this.baseController=baseController;
	   
	   baseLayout = new SpringLayout();
	   firstButton=new JButton("Please don't click the button");
	   
	   
	   firstTextField = new JTextField("words can be typed here");
	   
	   setupPanel();
	   setupLayout();
	   setupListeners();
   }
   private void setupPanel()
   {
	   this.setLayout(baseLayout);
	   this.add(firstButton);
	   this.add(firstTextField);
   }
   
   private void setupLayout()
   {
	   baseLayout.putConstraint(SpringLayout.NORTH)
   }
	
}
