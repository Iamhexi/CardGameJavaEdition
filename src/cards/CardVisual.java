package cards;

import java.awt.*;
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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

class CardVisual extends JLayeredPane implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public static JFrame frame;
	private int positionBuffer;
	
	protected JLabel picture;
	protected BufferedImage img;
	protected JLabel title;
	protected JTextPane description;
	
	protected Vector2i location;
	protected Timer timer;
	protected Timer timerForTimer;
	protected Vector2i velocity = new Vector2i();
	int animationDurationInMs = 5000;
	int timerTickPeriod = 30;

	protected String pathToPicture;
	
	protected static int cardWidth = 250;

	protected static int titleHeight = 50;
	protected static int pictureHeight = 300;
	protected static int descriptionHeight = 150;
	
	protected static Rectangle handArea = new Rectangle( 0, 600, 1920, 300 );
	protected static Rectangle battlefieldArea = new Rectangle( 0, 500, 1020, 300 );
	protected static Rectangle deckArea = new Rectangle( 1500, 600,  900, 300 );
	protected static Rectangle discardZoneArea = new Rectangle(3000, 3000, 1, 1);
	

	protected Point mousePosition;

	protected Boolean aboveCastingArea = false;
	protected Boolean underCursor = false;
	
	protected List<PlayingCardObserver> observers = new LinkedList<PlayingCardObserver>();

	boolean dragging = false;
	
	public CardVisual() {

		location = new Vector2i();
		this.setBounds(location.x, location.y, cardWidth, titleHeight + pictureHeight + descriptionHeight);

		title = new JLabel();
		picture = new JLabel();
		description = new JTextPane();

		this.setCardLayout(location);
		this.setBackground(new Color(0, 0, 0, 65));
		
		this.positionBuffer = frame.getComponentZOrder(this);

		Border b = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		this.setBorder(b);

		title.setFont(new Font("Serif", Font.BOLD, 24));
		
		description.setBackground(new Color(255, 255, 255, 0));
		description.setFont( new Font("Serif", Font.PLAIN, 17) );
		description.setPreferredSize( new Dimension (cardWidth-10, descriptionHeight-15) );
		description.setText("This is an example of a card's description. This is an example of a card's description.");
		description.setEditable(false);
		
		timerForTimer = new Timer(animationDurationInMs, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        timer.stop();
		    }
		});
		
		timerForTimer.start();
		
		timer = new Timer(timerTickPeriod, this);
		timer.start();

		addListeners();

		this.add(title);
		this.add(picture);
		this.add(description);
	}

	public CardVisual(String pathToPicture, Vector2i location) throws IOException {
		
		this.pathToPicture = pathToPicture;
		this.location = location;
		this.setBounds(location.x, location.y, cardWidth, titleHeight + pictureHeight + descriptionHeight);

		title = new JLabel();
		picture = new JLabel();
		description = new JTextPane();

		this.loadPictureFromFile(pathToPicture);
		this.setCardLayout(location);
		this.setBackground(new Color(0, 0, 0, 65));
		
		this.positionBuffer = frame.getComponentZOrder(this);

		Border b = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		this.setBorder(b);

		title.setFont(new Font("Serif", Font.BOLD, 24));
		
		description.setBackground(new Color(255, 255, 255, 0));
		description.setFont( new Font("Serif", Font.PLAIN, 17) );
		description.setPreferredSize( new Dimension (cardWidth-10, descriptionHeight-15) );
		description.setText("This is an example of a card's description. This is an example of a card's description.");
		description.setEditable(false);
		
		timerForTimer = new Timer(animationDurationInMs, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        timer.stop();
		    }
		});
		
		timerForTimer.start();
		
		timer = new Timer(timerTickPeriod, this);
		timer.start();

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
				toggleTopBottomPosition();
			}
		});

		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				int cardHeight = titleHeight + pictureHeight + descriptionHeight;
				
				if (handArea.contains( new Point ( e.getXOnScreen(), e.getYOnScreen() ) ))
					aboveCastingArea = true;
				else
					aboveCastingArea = false;
				
				if (underCursor)
				{
					setBounds(
						e.getXOnScreen() - (cardWidth / 2),
						e.getYOnScreen() - (cardHeight) / 2, 
						cardWidth,
						cardHeight
					);
					
				}
			}
		});
	}

	private void setCardLayout(Vector2i location) {
		title.setBounds(location.x, location.y, cardWidth, titleHeight);
		picture.setBounds(location.x, location.y + titleHeight, cardWidth, pictureHeight);
		description.setBounds(location.x, location.y + titleHeight + pictureHeight, cardWidth, descriptionHeight);
	}

	public void loadPictureFromFile(String pathToPicture) throws IOException {
		this.pathToPicture = pathToPicture;
		img = ImageIO.read(new File(pathToPicture));
		picture = new JLabel(new ImageIcon(img));
	}

	public void setTitle(String title) throws Exception {
		if (title.length() == 0)
			throw new Exception("Card title cannot be empty.");
		this.title.setText(title);
	}
	
	private void sendCardTo(Point location)
	{
		int distanceX = location.x - this.location.x;
		int distanceY = location.y - this.location.y;
		
		int velocityX = distanceX / (animationDurationInMs / timerTickPeriod);
		int velocityY = distanceY / (animationDurationInMs / timerTickPeriod);
		
		this.velocity = new Vector2i(velocityX, velocityY);
	}

	public void playCardDrawingAnimation() 
	{
		sendCardTo( handArea.getLocation() );
	}

	public void playCardResurrectingAnimation() 
	{
		sendCardTo( handArea.getLocation() );
	}

	public void playCardDiscardingAnimation() 
	{
		sendCardTo( discardZoneArea.getLocation() );
	}

	public void playCardPlayingAnimation()
	{
		sendCardTo( battlefieldArea.getLocation() );
	}

	public void informAllObservers()
	{
		for( PlayingCardObserver o: observers )
			o.inform(title.getText());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		location.x += velocity.x;
		location.y += velocity.y;
		
		this.setBounds(location.x, location.y, cardWidth, titleHeight + pictureHeight + descriptionHeight);
		repaint();
	}
	
	private void toggleTopBottomPosition()
	{
		if (frame.getComponentZOrder(this) != 0)
			frame.setComponentZOrder(this, 0);
		else
			frame.setComponentZOrder(this, positionBuffer);
	}
}
