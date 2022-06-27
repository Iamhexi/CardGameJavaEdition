package cards;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	
	protected Point mousePosition;
	
	protected boolean underCursor = false;
	
	boolean dragging = false;

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
		description.setEditable(false);
		description.setBackground(new Color(255, 255, 255, 255));
		
		addListeners();
		
		this.add(title);
		this.add(picture);
		this.add(description);
	}
	
	private void addListeners()
	{
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) 
			{
				underCursor = false;
				setBounds(e.getXOnScreen(), e.getYOnScreen(), cardWidth, titleHeight + pictureHeight + descriptionHeight);
				System.out.println( e.getXOnScreen() );
				System.out.println( e.getYOnScreen() );
			}
			  
			public void mousePressed(MouseEvent e)
			{
				underCursor = true;
			}
		});
		
		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e)
			{
				int cardHeight = titleHeight + pictureHeight + descriptionHeight;
				setBounds(e.getXOnScreen()-(cardWidth/2), e.getYOnScreen()-(cardHeight)/2, cardWidth, cardHeight);
			}
		});
	}
	
	private void setCardLayout(Vector2i location) 
	{
		title.setBounds(location.x, location.y, cardWidth, titleHeight);
		picture.setBounds(location.x, location.y + titleHeight, cardWidth, pictureHeight);
		description.setBounds(location.x, location.y + titleHeight + pictureHeight, cardWidth, descriptionHeight);
	}

	public void loadPictureFromFile(String pathToPicture) throws IOException 
	{
		img = ImageIO.read(new File(pathToPicture));
		picture = new JLabel(new ImageIcon(img));
	}

	public void setTitle(String title) throws Exception
{
		if (title.length() == 0)
			throw new Exception("Card title cannot be empty.");
		this.title.setText(title);
	}

	public void playCardDrawingAnimation() {
		// TODO Auto-generated method stub
	}

	public void playCardResurrectingAnimation() {
		// TODO Auto-generated method stub

	}

	public void playCardDiscardingAnimation() {
		// TODO Auto-generated method stub

	}

	public void playCardPlayingAnimation() {
		// TODO Auto-generated method stub

	}

}
