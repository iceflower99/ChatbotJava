package chat.veiw;

import chat.controler.ChatController;
import javax.swing.JPanel;
import javax. swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
public class ChatPanel extends  JPanel
{
   private ChatController baseController;
   private JButton firstButton;
   private JTextField typingField;
   private SpringLayout baseLayout;
   private JLabel promptLabel;
   private JTextArea chatArea;
   public ChatPanel(ChatController baseController)
   {
	   this.baseController=baseController;
	   baseLayout = new SpringLayout();
	   chatArea = new JTextArea(10,30);
	   typingField = new JTextField("words can be typed here");
	   firstButton=new JButton("Please don't click the button");
	   
	   
	  
	   
	   setupPanel();
	   setupLayout();
	   setupListeners();
   }
   private void setupPanel()
   {
	   this.setLayout(baseLayout);
	   this.add(firstButton);
	   this.add(typingField);
	  
	   }
   
   private void setupLayout()
   {
	   baseLayout.putConstraint(SpringLayout.NORTH, typingField,36,SpringLayout.SOUTH,firstButton);
	   baseLayout.putConstraint(SpringLayout.EAST, typingField, -127, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 64, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 58, SpringLayout.WEST, this);
   }
   private void setupListeners()
   {
	   firstButton.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent click)
		   {
			   typingField.setText("ow,this is the most amazing click event ever! WOW!");
		   }
	   });
   }
   public void actionPerformed(ActionEvent click)
   {
	   String userText= typingField.getText();
   }
	
}
