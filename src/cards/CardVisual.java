package cards;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

class CardVisual extends JPanel {
	private static final long serialVersionUID = 1L;

	protected JLabel picture;
	protected BufferedImage img;
	protected JLabel title;
	protected JTextPane description;

	protected static int cardWidth = 250;

	protected static int titleHeight = 50;
	protected static int pictureHeight = 300;
	protected static int descriptionHeight = 150;
	protected static Rectangle cardCastingArea = new Rectangle( 0, 500, 1920, 300 );

	protected Point mousePosition;

	protected Boolean aboveCastingArea = false;
	protected Boolean underCursor = false;
	
	protected List<PlayingCardObserver> observers = new LinkedList<PlayingCardObserver>();

	boolean dragging = false;

	public CardVisual()
	{
		title = new JLabel();
		picture = new JLabel();
		description = new JTextPane();
	}

	public CardVisual(String pathToPicture, Vector2i location) throws IOException {
		this.setBounds(location.x, location.y, cardWidth, titleHeight + pictureHeight + descriptionHeight);

		title = new JLabel();
		picture = new JLabel();
		description = new JTextPane();

		this.loadPictureFromFile(pathToPicture);
		this.setCardLayout(location);
		this.setBackground(new Color(0, 0, 0, 65));
		

		Border b = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		this.setBorder(b);

		title.setFont(new Font("Serif", Font.BOLD, 24));
		
		description.setBackground(new Color(0, 0, 0, 0));
		description.setFont( new Font("Serif", Font.PLAIN, 17) );
		description.setPreferredSize( new Dimension (cardWidth-10, descriptionHeight-15) );
		description.setText("This is an example of a card's description. This is an example of a card's description.");
		description.setEditable(false);

		addListeners();

		this.add(title);
		this.add(picture);
		this.add(description);
	}

	private void addListeners() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (aboveCastingArea)
					informAllObservers();
					
				underCursor = !underCursor;
			}
		});

		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				int cardHeight = titleHeight + pictureHeight + descriptionHeight;
				
				if (cardCastingArea.contains( new Point ( e.getXOnScreen(), e.getYOnScreen() ) ))
					aboveCastingArea = true;
				else
					aboveCastingArea = false;
				
				if (underCursor)
					setBounds(
						e.getXOnScreen() - (cardWidth / 2),
						e.getYOnScreen() - (cardHeight) / 2, 
						cardWidth,
						cardHeight
					);
			}
		});
	}

	private void setCardLayout(Vector2i location) {
		title.setBounds(location.x, location.y, cardWidth, titleHeight);
		picture.setBounds(location.x, location.y + titleHeight, cardWidth, pictureHeight);
		description.setBounds(location.x, location.y + titleHeight + pictureHeight, cardWidth, descriptionHeight);
	}

	public void loadPictureFromFile(String pathToPicture) throws IOException {
		img = ImageIO.read(new File(pathToPicture));
		picture = new JLabel(new ImageIcon(img));
	}

	public void setTitle(String title) throws Exception {
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

	public void informAllObservers()
	{
		for( PlayingCardObserver o: observers )
			o.inform(title.getText());
	}

}
