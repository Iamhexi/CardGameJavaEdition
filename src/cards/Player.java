package cards;

import javax.swing.JFrame;

public final class Player implements PlayingCardObserver
{
	private PlayerLogic playerLogic;
	private PlayerVisual playerVisual;
	
	public Player(String name, int initialHealth, String pathToPicture, Vector2i location, JFrame frame) throws Exception
	{
		playerLogic = new PlayerLogic(initialHealth, frame);
		playerVisual = new PlayerVisual(name, pathToPicture, location);
	}
	
	public String getName()
	{
		return playerVisual.getName();
	}
	
	public void addCardToDeck(Card card)
	{
		card.registerObserver(this);
		playerLogic.deck.addCard(card);
	}
	
	public void drawCard()
	{
		playerLogic.drawCard(); 
		playerVisual.playDrawCardAnimation();
	}
	
	public void takeDamage(int amount)
	{
		playerLogic.takeDamage(amount); 
		playerVisual.playTakeDamageAnimation(amount);
	}
	
	public void healDamage(int amount)
	{
		playerLogic.healDamage(amount); 
		playerVisual.playHealDamageAnimation(amount); 
	}
	
	public void initialise(JFrame frame)
	{
		frame.add(playerVisual);
	}
	
	public void playCard(String cardTitle)
	{
		playerLogic.deck.play(cardTitle);
	}
	
	public void inform(String cardTitle)
	{
		System.out.println("Card titled '" + cardTitle  + "' has been played.");
		playerLogic.deck.play(cardTitle);
	}
	
}
