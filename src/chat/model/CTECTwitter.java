package chat.model;

import java.util.*;
import twitter4j,*;
import java.io.*;
import chat.controler.ChatController;
public class CTECTwitter
{
private Twitter chatbotTwitterl;
private ListArrayList<Status> statuses;
private ListArrayList<String> tweetTexts;
private ChatController BaseController;

public CTECTwitter()
{
	this.baseController= baseController;
	chatbotTwitter = TwitterFactory.getSingleton();
	statuses = new ArrayList<Status>();
	tweetTexts= new ArrayList<String>();
}

public void sendTWeet(String tweet)
{
	
}

public String topResults(List<String> wordList)
{
	
}

}
