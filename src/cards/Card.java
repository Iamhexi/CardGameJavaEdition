package cards;


import java.io.IOException;

import javax.swing.JComponent;


public class Card
{
	public static GameManager gameManager;
	
	protected CardLogic cardLogic;
	protected CardVisual cardVisual;

	public CardLocation getLocation()
	{
		return cardLogic.location;
	}
	
	public Card()
	{
		cardLogic = new CardLogic();
		cardVisual = new CardVisual();
		
		setOnPlay( () -> {} );
		setOnDiscard( () -> {} );
		setOnResurrect( () -> {} );
		setOnDraw( () -> {} );
	}
	
	public Card(String pathToPicture, Vector2i location) throws IOException
	{
		cardLogic = new CardLogic();
		cardVisual = new CardVisual(pathToPicture, location);
		
		setOnPlay( () -> {} );
		setOnDiscard( () -> {} );
		setOnResurrect( () -> {} );
		setOnDraw( () -> {} );
	}
	
	public void play()
	{
		cardLogic.play();
		cardVisual.playCardPlayingAnimation();
	}
	
	public void discard()
	{
		cardLogic.discard();
		cardVisual.playCardDiscardingAnimation();
	}
	
	public void resurrect()
	{
		cardLogic.resurrect();
		cardVisual.playCardResurrectingAnimation();
	}
	
	public void draw()
	{
		cardLogic.draw();
		cardVisual.playCardDrawingAnimation();
	}

	public void setOnPlay(Runnable action) 
	{
		cardLogic.setOnPlay(action);
	}
	
	public void setOnDiscard(Runnable action) 
	{
		cardLogic.setOnDiscard(action);
	}
	
	public void setOnResurrect(Runnable action) 
	{
		cardLogic.setOnResurrect(action);
	}
	
	public void setOnDraw(Runnable action) 
	{
		cardLogic.setOnDraw(action);
	}
	
	
	public JComponent getCardVisuals()
	{
		return cardVisual;
	}

	public int getId() 
	{
		return cardLogic.getId();
	}
	
	public String getTitle()
	{
		return cardVisual.title.getText();
	}
		
	
}
