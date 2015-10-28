package chat.controler;

import chat.veiw.ChatView;
import chat.model.Chatbot;

/**
 * Application controller for the Chatbot project.
 * @author madeleine hales
 *@version 1.11 10/21/15 fixed error ;)
 */

public class ChatController {
	
	private ChatView myDisplay;
	private Chatbot myBot;
	 
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabInput("What is your name?");
	  myBot = new Chatbot(userName);
	}
	
	
	public void start()
	{
		myDisplay.grabInput("Hello " + myBot.getUserName());
		chat();
	}

	private void chat()
	{
		String conversation = myDisplay.grabInput("What would you like to talk about toady");
		while(myBot.lengthChecker(conversation))
		{
			if(myBot.lengthChecker(conversation))
			{
			 myDisplay.grabInput("wow, I had no idea you are intrested in "+ myBot.getContent());
			}
			conversation=myDisplay.grabInput(conversation);
		}
	}
	
}
