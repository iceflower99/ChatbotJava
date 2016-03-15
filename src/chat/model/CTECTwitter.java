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
		chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @madeleinehales!");
	}
	catch (TwitterException error)
	{
		baseController.handleErrors(error.getErrorMessage());
		
	}


}

public void loadTweets(String twitterHandle) throws TwitterException
{
	Paging statusPage = new Paging(1,200);
	int page = 1;
	while (page <=10)
	{
		statusPage.setPage(page);
		statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle,statusPage));
		page++;
	}
	 for( Status currentStatus:statuses)
	 {
		 String[] tweetText = currentStatus.getText().split(" ");
		 for ( String word :tweetText )
		 {
			 tweetTexts.add(removePunctuation(word).toLowerCase());
		 }
	 }
     removeCommonEnglishWords(tweetTexts);
     removeEmptyText();
}

private void removeEmptyText()
{
	
}

private List removeCommonEnglishWords(List<String> wordList)
{
	return null;
}

private String removePunctuation(String currentString)
{
	String punctuation = ".,'?!:;\" () {} ^[]<>-";
	
	String scrubbedString="";
	for(int i = 0; i< currentString.length(); i++)
	{
		if(punctuation.indexOf(currentString.charAt(i))==-1)
		{
			scrubbedString += currentString.charAt(i);
		}
	}
	
	
	return scrubbedString;
}



}
