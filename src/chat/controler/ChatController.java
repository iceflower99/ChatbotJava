package chat.controler;

import chat.veiw.ChatView;
import chat.model.Chatbot;
import chat.veiw.ChatFrame;
import chat.model.CTECTwitter;
/**
 * Application controller for the Chatbot project.
 * @author madeleine hales
 *@version 1.11 10/21/15 fixed error ;)
 */

public class ChatController {
	
	private ChatView myDisplay;
	private Chatbot myBot;
	private ChatFrame baseFrame; 
	private CTECTwitter maddyTwitter;
	public ChatController()
	{
		myDisplay = new ChatView();
		String user = myDisplay.grabInput("What is your name?");
	  myBot = new Chatbot(user);
	  maddyTwitter = new CTECTwitter(this);
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
		while(myBot.lengthChecker(conversation))
		{
			
		}
		
	}
	private void shutDown()
	{
		
		myDisplay.grabInput("Goodbye, "+ myBot.getUserName()+"it has been my pleasure to alk with you");
		
	}
	
	
	public String analyze(String userName)
	{
		String userAnalysis="The Twitter user "+ userName + "has  ....";
		
		return userAnalysis;
	}
	
	public void handleErrors(String errorMessage)
	{
		myDisplay.showResponse(errorMessage);
	}
}
