package chat.veiw;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * Popup display for GUI interaction in the Chatbot project.
 *  @author madeleine hales
 *@version 1.3 11/5/25 added Icons to poup windows
 */
public class ChatView 
{

    private String windowMessage;
    private ImageIcon chatIcon;
	
    public  ChatView()
    {
    	windowMessage = "Hello from your friendly chatbot :D";
    	chatIcon=new ImageIcon(getClass().getResource("images/sexygermany.png"));
    	
    	
    }
    
	public void showResponse(String displayText)
    {
    	JOptionPane.showMessageDialog(null,displayText,windowMessage,JOptionPane.INFORMATION_MESSAGE, chatIcon);    	
    }
	
	public  String grabInput (String displayText)
{
	String returnedText="";
	returnedText=JOptionPane.showInputDialog(null,displayText,windowMessage, JOptionPane.PLAIN_MESSAGE,chatIcon,null,"Answer here:)")+"";
	
	return returnedText;
}
	


}
