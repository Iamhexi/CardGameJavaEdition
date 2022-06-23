package cards;

public abstract class Player
{
	protected static int idCounter = 0;
	protected int health;
	
	protected static int id;
	protected Deck deck;
	
	
	public Player()
	{
		health = 20;
		id = idCounter++;
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
		deck.moveRandomCard(CardLocation.Deck, CardLocation.Hand);
	}
}
