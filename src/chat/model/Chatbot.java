package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project.
 * 
 * @author Madeleine hales
 * @version 1.2 10/21/15 Completed the lengthChecker method. Fixed the
 *          Constructor and getter for userName.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicsList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		memesList = new ArrayList<String>();
		politicalTopicsList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Motivational Sign" + "!";

		buildMemesList();
		buildPoliticalTopicsList();
	}

	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("bad luck brian");
		this.memesList.add("spoderman");
		this.memesList.add("aliens!");
		this.memesList.add("what if I told you");
		this.memesList.add("unhelpful high school teacher");
		this.memesList.add("me gusta");
		this.memesList.add("rare pepe");
		this.memesList.add("troll");
		this.memesList.add("John cena");
		this.memesList.add("rick rolled");
	}

	private void buildPoliticalTopicsList()
	{
		this.politicalTopicsList.add("democrat");
		this.politicalTopicsList.add("republican");
		this.politicalTopicsList.add("independent");
		this.politicalTopicsList.add("election");
		this.politicalTopicsList.add("liberal");
		this.politicalTopicsList.add("conservative");
		this.politicalTopicsList.add("Trump");
		this.politicalTopicsList.add("Clinton");
		this.politicalTopicsList.add("Biden");
		this.politicalTopicsList.add("Carson");
		this.politicalTopicsList.add("Rubio");
		this.politicalTopicsList.add("Fiorina");
		this.politicalTopicsList.add("Sanders");
		this.politicalTopicsList.add("vote");
		this.politicalTopicsList.add("11/8/2016");

	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;

		if (currentInput != null)
		{
			if (currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}

		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;

		if (currentInput.toLowerCase().contains(content))
		{
			hasContent = true;
		}
		return hasContent;
	}

	public boolean keyboardMashChecker(String currentInput)
	{
		boolean hasMash = false;
		if(currentInput.equals("sdf" )|| currentInput.equals("dfg")|| currentInput.equals("cvb") || currentInput.equals(",./"))
		{
			hasMash=true;
		}
			
		return hasMash;
			
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean politicalTopics = false;
		
		for(String topics : politicalTopicsList)
		{
			if (currentInput.toLowerCase().contains(topics.toLowerCase()))
			{
				politicalTopics=true;
			}
		}
	    
		return politicalTopics;
		
	}

	/**
	 * Checks to see that the supplied String value is in the current memesList
	 * variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMemes = false;

		for (String meme : memesList)
		{
			if (currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMemes = true;
			}
		}

		return hasMemes;
	}

	public String processConversation(String currentInput)
	{
		String nextConversation = "oh,what esle would you like to talk about";
		int randomTopic = (int) (Math.random() * 5); // Generates a random
														// number between 0 and
														// 4;\
		quitChecker(currentInput);

		switch (randomTopic)
		{
		case 0:
			if (memeChecker(currentInput))
			{
				nextConversation = "That is a very popular meme this year. What else are you " + "wanting to talk about?";
			}
			break;
		case 1:
			if (politicalTopicChecker(currentInput))
			{
				nextConversation = "That's nice. Do you want to talk about something else? ";
			}
			break;
		case 2:
			if (contentChecker(currentInput))
			{
				nextConversation = "Wow i had no idea you re into that kinda of stuff. Is there anything else you want to talk about?";
			}
			break;
		case 3:
			if (currentInput.equals("hetalia"))
			{
				nextConversation = "I'm a fan of hetalia too it's so funny. Do you want to talk about anything else?";
			}
			break;
		case 4:
			nextConversation = "Hmm I don't think i've heard of that before. What else are going to talk about";
			break;
		default:
			nextConversation = "uh oh that's not good.";
			break;
		}

		return nextConversation;
	}

	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}

	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{

	}
	
	public boolean quitChecker(String content)
	{
		if (content == "exit" || content == "quit")
			System.exit(0);
		return true;
	}
}
