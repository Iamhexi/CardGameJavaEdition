package cards;

import java.io.IOException;

public abstract class Card 
{
	protected CardLogic cardLogic;
	protected CardVisual cardVisual;
	
	
	
	public Card()
	{
		cardLogic = new CardLogic();
		cardVisual = new CardVisual();
	}
	
	public Card(String pathToPicture) throws IOException
	{
		cardLogic = new CardLogic();
		cardVisual = new CardVisual();
		cardVisual.loadPictureFromFile(pathToPicture);
	}
}
