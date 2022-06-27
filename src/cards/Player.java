package cards;

import java.io.IOException;

public final class Player
{
	private PlayerLogic playerLogic;
	private PlayerVisual playerVisual;
	
	public Player()
	{
		playerLogic = new PlayerLogic();
		playerVisual = new PlayerVisual();
	}
	
	public Player(String name, int initialHealth, String pathToPicture, Vector2i location) throws Exception
	{
		playerLogic = new PlayerLogic(initialHealth);
		playerVisual = new PlayerVisual(name, pathToPicture, location);
	}
	
	public String getName()
	{
		return playerVisual.getName();
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
	
	public PlayerVisual getPlayerVisual()
	{
		return playerVisual;
	}
	
}
