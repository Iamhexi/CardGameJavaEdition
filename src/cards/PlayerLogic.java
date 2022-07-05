package cards;

import javax.swing.JFrame;

public class PlayerLogic
{
	protected static int idCounter = 0;
	protected int health;
	
	protected static int id;
	protected Deck deck;
	
	public PlayerLogic(int initialHealth, JFrame frame) throws Exception
	{
		if (initialHealth <= 0)
			throw new Exception("Initial health cannot be less than or equal to zero.");
		health = initialHealth;
		deck = new Deck(frame);
	}
	
	public void takeDamage(int amount)
	{
		health -= amount;
	}
	
	public void healDamage(int amount)
	{
		this.takeDamage(-amount);
	}
	
	public int getId()
	{
		return id;
	}
	
	public void drawCard()
	{
		deck.drawRandom();
	}
}
