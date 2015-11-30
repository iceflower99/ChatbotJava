
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
 	private void setUpFrame()
 	{
 		this.setContentPane(basePanel);
 		this.setSize(400,400);
 		this.setResizable(false);
 		this.setVisible(true); 		
 	}
 	
 	public ChatController getbaseController()
 	{
 		return baseController;
 	}
	
}
