
package chat.veiw;

import javax.swing.JFrame;
import chat.controler.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
 	private ChatPanel basePanel;
 
 	public ChatFrame(ChatController baseController)
 	{
 		this.baseController= baseController;
 		basePanel= new ChatPanel(baseController);
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
