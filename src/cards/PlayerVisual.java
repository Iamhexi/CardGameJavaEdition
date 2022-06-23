package cards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class PlayerVisual 
{
	protected JLabel picture;
	protected BufferedImage img;
	protected Vector2i location;
	protected Vector2i size;
	
	public PlayerVisual()
	{
		picture = new JLabel();
	}
	
	public PlayerVisual(String pathToPicture, Vector2i location, Vector2i size) throws IOException
	{
		loadPictureFromFile(pathToPicture);
		picture.setBounds(location.x, location.y, size.x, size.y);
	}
	
	private void loadPictureFromFile(String pathToFile) throws IOException
	{
		img = ImageIO.read( new File(pathToFile) );
		picture = new JLabel(new ImageIcon(img));
	}

	public void playDrawCardAnimation() 
	{
		// TODO Auto-generated method stub
	}

	public void playHealDamageAnimation(int amount) 
	{
		// TODO Auto-generated method stub
	}

	public void playTakeDamageAnimation(int amount) 
	{
		// TODO Auto-generated method stub
	}
	
}
