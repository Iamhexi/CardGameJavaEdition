package cards;

import java.awt.*;


import javax.swing.*;

public abstract class Card 
{
	protected Canvas picture;
	protected JLabel title;
	protected JTextPane description;
	protected int id;
	
	protected Runnable onDiscard;
	protected Runnable onPlay;
	protected Runnable onDraw;
	protected Runnable onResurrect;
	
	
	public static GameManager gameManager;
	public static int idCounter = 0;
	public CardLocation location;
	
	public abstract void onDiscard(); // effect invoked whilst the card is being discarded
	public abstract void onPlay();
	public abstract void onDraw();
	public abstract void onResurrect(); // effect invoked whilst the card is being moved from discard zone to hand
	
	public Card()
	{
		location = CardLocation.Hand;
		id = idCounter++;
		title = new JLabel();
		picture = new Canvas();
		description = new JTextPane();
	}
	
	
	public void setOnDiscard(Runnable onDiscard) 
	{
		this.onDiscard = onDiscard;
	}
	
	public void setOnPlay(Runnable onPlay) 
	{
		this.onPlay = onPlay;
	}
	
	public void setOnDraw(Runnable onDraw) 
	{
		this.onDraw = onDraw;
	}
	
	public void setOnResurrect(Runnable onResurrect) {
		this.onResurrect = onResurrect;
	}
	
	public static void setGameManager(GameManager gameManager)
	{
		Card.gameManager = gameManager;
	}
	
	public void setTitle(String title) throws Exception
	{
		if (title.length() == 0)
			throw new Exception("Card title cannot be empty.");
		this.title.setText(title);
	}
	
	public int getId()
	{
		return id;
	}
	
	
}
