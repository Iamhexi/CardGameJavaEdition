package cards;


import javax.swing.JFrame;


public class Card
{
	public static GameManager gameManager;
	
	protected CardLogic cardLogic;
	protected CardVisual cardVisual;

	public CardLocation getLocation()
	{
		return cardLogic.location;
	}
	
	public Card(String title, String pathToPicture, Vector2i location) throws Exception
	{
		cardLogic = new CardLogic();
		cardVisual = new CardVisual(pathToPicture, location);
		cardVisual.setTitle(title);
		
		setOnPlay( () -> { System.out.println("I got played ;)"); } );
		setOnDiscard( () -> {} );
		setOnResurrect( () -> {} );
		setOnDraw( () -> {} );
	}
	
	public void setDescription(String description)
	{
		cardVisual.description.setText(description);
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
	
	
	public void initialise(JFrame frame)
	{
		frame.add(cardVisual);
	}

	public int getId() 
	{
		return cardLogic.getId();
	}
	
	public String getTitle()
	{
		return cardVisual.title.getText();
	}
	
	public void registerObserver(PlayingCardObserver o)
	{
		cardVisual.observers.add(o);
	}
		
	
}
