package chat.controler;

import chat.veiw.ChatView;
import chat.model.Chatbot;
import chat.veiw.ChatFrame;
/**
 * Application controller for the Chatbot project.
 * @author madeleine hales
 *@version 1.11 10/21/15 fixed error ;)
 */

public class ChatController {
	
	private ChatView myDisplay;
	private Chatbot myBot;
	private ChatFrame baseFrame; 
	public ChatController()
	{
		myDisplay = new ChatView();
		String user = myDisplay.grabInput("What is your name?");
	  myBot = new Chatbot(user);
	  baseFrame=new ChatFrame(this);
	}
	
	
	public void start()
	{
		myDisplay.grabInput("Hello " + myBot.getUserName());
		chat();
	}

	private void chat()
	{
		String conversation = myDisplay.grabInput("What would you like to talk about toady");
	
		
	}
	
}
