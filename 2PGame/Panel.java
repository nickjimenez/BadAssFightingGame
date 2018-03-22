import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	
	protected void paintComponent(Graphics PlayScreen) {
		super.paintComponent(PlayScreen);
		Image PlayStartImage = new ImageIcon("PlayStart.jpg").getImage();
		int x = 0;
		int y = 0;
		PlayScreen.drawImage(PlayStartImage, x, y, null);
	}
	
	protected void paintCompinent(Graphics VsScreen){
		super.paintComponent(VsScreen);
		Image VsScreenImage = new ImageIcon("Vs.jpg").getImage();
		int x = 0;
		int y = 0;
		VsScreen.drawImage(VsScreenImage, x, y, null);
	}
}