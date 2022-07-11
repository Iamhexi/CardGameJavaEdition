package cards;


import javax.swing.JFrame;
import javax.swing.JLabel;


public class Card
{
	public static GameManager gameManager;
	
	protected CardLogic cardLogic;
	protected CardVisual cardVisual;

	public CardLocation getLocation()
	{
		return cardLogic.location;
	}
	
	Card(
		String title,
		String description,
		String pathToPicture,
		Vector2i visualLocation,
		CardLocation logicalLocation,
		Runnable onPlay,
		Runnable onDiscard,
		Runnable onResurrect,
		Runnable onDraw
	) throws Exception {
		
		cardLogic = new CardLogic();
		cardVisual = new CardVisual();
		cardVisual.setTitle(title);
		cardVisual.description.setText(description);
		cardVisual.loadPictureFromFile(pathToPicture);
		
		cardLogic.location = logicalLocation;
		
		if (onPlay == null)
			onPlay = () -> {};
		if (onDiscard == null)
			onDiscard = () -> {};
		if (onResurrect == null)
			onResurrect = () -> {};
		if (onDraw == null)
			onDraw = () -> {};
		
		cardLogic.onPlay = onPlay;
		cardLogic.onDiscard = onDiscard;
		cardLogic.onResurrect = onResurrect;
		cardLogic.onDraw = onDraw;
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
