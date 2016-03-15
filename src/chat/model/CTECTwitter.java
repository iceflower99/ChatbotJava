package chat.model;

import java.util.*;
import twitter4j.*;
import chat.controler.ChatController;
import java.io.*;
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
	
	for (int spot=0; spot <tweetTexts.size(); spot++)
	{
		if(tweetTexts.get(spot).equals(" "))
		{
			tweetTexts.remove(spot);
			spot--;
		}
	}
}

 private String[] importWordsToArray()
 {
	 String[] boringWords;
	 int wordCount = 0;
	 try
	 {
		 Scanner wordFile= new Scanner(new File("commonWords.txt"));
		 while (wordFile.hasNext())
		 {
			 wordCount++;
			 wordFile.next();
		 }
		 wordFile.reset();
		 boringWords= new String[wordCount];
		 int boringWordCount= 0;
		 while (wordFile.hasNext())
		 {
			 boringWords[boringWordCount]=wordFile.next();
			 boringWordCount++;
		 }
        wordFile.close();	 
	 }
	 catch (FileNotFoundException e)
	 {
		 return new String[0];
	 }
	 return boringWords;
 }

private List removeCommonEnglishWords(List<String> wordList)
{
	String[] boringWords= importWordsToArray();
	
	for(int count = 0; count< wordList.size();count++)
	{
		for(int removeSpot=0; removeSpot<boringWords.length; removeSpot++)
		{
			if(wordList.get(count).equals(boringWords[removeSpot]))
			{
				wordList.remove(count);
				count--;
				removeSpot=boringWords.length;
			}
		}
	}
	//removeTwitterUsernamesFromList(wordList);
	
	return wordList;
	
	
}

public String topResults()
{
	String tweetResults = "";
	
	int topWordLocation=0;
	
	int topCount=0;
	
	for(int index =0; index< tweetTexts.size(); index++)
	{
		
		int wordUseCount=0;
		
		for(int spot = 0; spot< tweetTexts.size();spot++)
		{
			
			if(tweetTexts.get(index).equals(tweetTexts.get(spot)))
			{
				wordUseCount++;
			}
			if(wordUseCount>topCount)
			{
				topCount = wordUseCount;
				topWordLocation=index;
			}
		}
	}
	
	tweetResults = "The top word in the tweets was " + tweetTexts.get(topWordLocation) + " and it was used " +topCount + " times!";
	return tweetResults;
	
	
}


	// Removes defined punctuation 

private String removePunctuation(String currentString)
{
	String punctuation = ".,'?!:;\" () {} ^[]<>-@";
	
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
