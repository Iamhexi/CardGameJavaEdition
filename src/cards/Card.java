package cards;


import java.io.IOException;

import javax.swing.JComponent;


public class Card
{
	public static GameManager gameManager;
	
	protected CardLogic cardLogic;
	protected CardVisual cardVisual;
	
	public Card()
	{
		cardLogic = new CardLogic();
		cardVisual = new CardVisual();
	}
	
	public Card(String pathToPicture, Vector2i location) throws IOException
	{
		cardLogic = new CardLogic();
		cardVisual = new CardVisual(pathToPicture, location);
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
		cardLogic.setOnPlay(action);
	}
	
	public void setOnResurrect(Runnable action) 
	{
		cardLogic.setOnPlay(action);
	}
	
	public void setOnDraw(Runnable action) 
	{
		cardLogic.setOnPlay(action);
	}
	
	
	public JComponent getCardVisuals()
	{
		return cardVisual;
	}
	
		
		
	
}
