package chat.veiw;

import javax.swing.JOptionPane;

public class ChatView 
{

	public void showResponse(String wordsFromSomewhere)
    {
    	JOptionPane.showMessageDialog(null,wordsFromSomewhere);    	
    }
	
	public  String grabInput (String stuff)
{
	String returnedText="";
	returnedText=JOptionPane.showInputDialog(null,stuff);
	
	return returnedText;
}
	


}
