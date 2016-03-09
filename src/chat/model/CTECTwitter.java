package chat.model;

import java.util.*;
import twitter4j.*;
import chat.controler.ChatController;
public class CTECTwitter

/** 
 * @ author <madeleine hales>
 * @ version .4 Feb 25, 2016 - chnaged the seend tweet method to handle erros. 
 */
{
private Twitter chatbotTwitter;
private ArrayList<Status> statuses;
private ArrayList<String> tweetTexts;
private ChatController baseController;

public CTECTwitter(ChatController baseController)
{
	this.baseController = baseController;
	chatbotTwitter = TwitterFactory.getSingleton();
	statuses = new ArrayList<Status>();
	tweetTexts= new ArrayList<String>();
}

public void sendTweet(String tweet)
{
	try
	{
		chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
	}
	catch (TwitterException error)
	{
		baseController.handleErrors(error.getErrorMessage());
		
	}


}



}
