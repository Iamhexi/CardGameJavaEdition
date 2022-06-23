package cards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class CardVisual
{
	protected JLabel picture;
	protected BufferedImage img;
	protected JLabel title;
	protected JTextPane description;
	
	public CardVisual()
	{
		title = new JLabel();
		picture = new JLabel();
		description = new JTextPane();
	}
	
	public CardVisual(String pathToPicture, Vector2i location, Vector2i size) throws IOException
	{
		this.loadPictureFromFile(pathToPicture);
		
		// TODO implement setting sizes and location of card elements
	}
	
	public void loadPictureFromFile(String pathToPicture) throws IOException
	{
		img = ImageIO.read( new File(pathToPicture) );
		picture = new JLabel(new ImageIcon(img));
	}
	
	public void setTitle(String title) throws Exception
	{
		if (title.length() == 0)
			throw new Exception("Card title cannot be empty.");
		this.title.setText(title);
	}
}
