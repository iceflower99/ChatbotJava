package chat.veiw;

import chat.controler.ChatController;
import javax.swing.JPanel;
import javax.swing.JButton;
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
   private JButton analyzeTwitterButton;
   private JButton saveButton;
   
   
   public ChatPanel(ChatController baseController)
   {
	   this.baseController=baseController;
	   baseLayout = new SpringLayout();
	   chatArea = new JTextArea(10,30);
	   typingField = new JTextField("words can be typed here");
	   firstButton=new JButton("Please don't click the button");
	   baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -6, SpringLayout.NORTH, firstButton);
	   tweetButton = new JButton("send tweet");
	   baseLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, tweetButton);
	   analyzeTwitterButton = new JButton("Analyse some tweets");
	   saveButton = new JButton("save tweets");
	   loadButton = new JButton("load tweets");
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
	   chatArea.setBackground(Color.ORANGE);
	   textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	   textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   }
   private void setupLayout()
   {
	   baseLayout.putConstraint(SpringLayout.NORTH, textPane, 36, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -127, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 64, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 58, SpringLayout.WEST, this);
   }
   private void setupPanel()
   {
	   this.setLayout(baseLayout);
	   this.add(firstButton);
	   this.add(textPane);
       this.add(typingField);
       this.add(tweetButton);
       this.add(analyzeTwitterButton);
	   this.add(saveButton);
	   this.add(loadButton);
   }
   
  
   private void setupListeners()
   {
	   firstButton.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent click)
		   {
			   typingField.setText("wow,this is the most amazing click event ever! WOW!");
		   }
	   });
	   tweetButton.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent click)
		   {
			   typingField.setText("no text to send");
			   baseController.sendTweet(" ");
		   }
	   });
	   
	   analyzeTwitterButton.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent click)
		   {
			   String user = typingField.getText();
			   String results = baseController.analyze(user);
			   chatArea.setText(results);
			   		   
		   }
	   });
	   
   
   
   saveButton.addActionListener(new ActionListener()
   {
	  public void actionPerformed(ActionEvent click)
	  {
		  String loadedText = IOController.readTextFromFile(promptLabel.getText());
		  chatArea.setText(loadedText);
	  }
   });
   
   public void actionPerformed(ActionEvent click)
   {
	   String userText= typingField.getText();
   }
	
}
