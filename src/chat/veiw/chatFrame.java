
package chat.veiw;

import javax.swing.JFrame;
import chat.controler.ChatController;

public class chatFrame extends JFrame
{
	private ChatController baseController;
 	private chatPanel basePanel;
 
 	public chatFrame(ChatController baseController)
 	{
 		this.baseController= baseController;
 		basePanel= new chatPanel(baseController);
 		setUpFrame();
 	}
	
}
