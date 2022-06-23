package cards;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

class CardVisual extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	protected JLabel picture;
	protected BufferedImage img;
	protected JLabel title;
	protected JTextPane description;
	
	
	protected static int cardWidth = 250;
	
	protected static int titleHeight = 50;
	protected static int pictureHeight = 300;
	protected static int descriptionHeight = 150;
	
	public CardVisual()
	{
		title = new JLabel();
		picture = new JLabel();
		description = new JTextPane();
	}
	
	public CardVisual(String pathToPicture, Vector2i location) throws IOException
	{
		this.setBounds(location.x, location.y, cardWidth, titleHeight + pictureHeight + descriptionHeight);
		
		title = new JLabel();
		picture = new JLabel();
		description = new JTextPane();
		
		this.loadPictureFromFile(pathToPicture);
		this.setCardLayout(location);
		
		title.setText("Any text");
		title.setFont(new Font("Serif", Font.BOLD, 30));
		description.setText("Any fucking text");
		
		this.add(title);
		this.add(picture);
		this.add(description);
	}
	
	private void setCardLayout(Vector2i location)
	{
		title.setBounds(location.x, location.y, cardWidth, titleHeight);
		picture.setBounds(location.x, location.y + titleHeight, cardWidth, pictureHeight);
		description.setBounds(location.x, location.y + titleHeight + pictureHeight, cardWidth, descriptionHeight);
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

	public void playCardDrawingAnimation() 
	{
		// TODO Auto-generated method stub
	}

	public void playCardResurrectingAnimation() 
	{
		// TODO Auto-generated method stub
		
	}

	public void playCardDiscardingAnimation() 
	{
		// TODO Auto-generated method stub
		
	}

	public void playCardPlayingAnimation() 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{

	    super.paintComponent(g);
	      g.setColor(Color.YELLOW);
	      g.fillOval(10, 10, 200, 200);
	      // draw Eyes
	      g.setColor(Color.BLACK);
	      g.fillOval(55, 65, 30, 30);
	      g.fillOval(135, 65, 30, 30);
	      // draw Mouth
	      g.fillOval(50, 110, 120, 60);
	      // adding smile
	      g.setColor(Color.YELLOW);
	      g.fillRect(50, 110, 120, 30);
	      g.fillOval(50, 120, 120, 40);
     
		//g.drawImage(img, 0, 0, null);
	}


	
}
