package cards;

public class PlayerLogic
{
	protected static int idCounter = 0;
	protected int health;
	
	protected static int id;
	protected Deck deck;
	
	public PlayerLogic(int initialHealth) throws Exception
	{
		if (initialHealth <= 0)
			throw new Exception("Initial health cannot be less than or equal to zero.");
		health = initialHealth;
	}
	
	public PlayerLogic()
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
		// TODO implement this method
	}
}
