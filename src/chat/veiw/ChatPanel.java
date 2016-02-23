package chat.veiw;

import chat.controler.ChatController;
import javax.swing.JPanel;
import javax. swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
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
   private JButton tweetButton;
   private JButton loadButton;
   private JScrollPane textPane;
   
   public ChatPanel(ChatController baseController)
   {
	   this.baseController=baseController;
	   baseLayout = new SpringLayout();
	   chatArea = new JTextArea(10,30);
	   typingField = new JTextField("words can be typed here");
	   firstButton=new JButton("Please don't click the button");
	   
	   setupChatPane();
	   setupPanel();
	   setupLayout();
	   setupListeners();
   }
   
   private void setupChatPane()
   {
	
	   textPane = new JScrollPane(chatArea);
	   chatArea.setLineWrap(true);
	   chatArea.setWrapStyleWord(true);
	   chatArea.setEditable(false);
	   textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	   textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   }
   
   private void setupPanel()
   {
	   this.setLayout(baseLayout);
	   this.add(firstButton);
	   this.add(textPane);
	   this.add(typingField);
	   }
   
   private void setupLayout()
   {
	  
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
