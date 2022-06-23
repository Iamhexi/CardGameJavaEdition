package cards;

public final class Player
{
	private PlayerLogic playerLogic;
	private PlayerVisual playerVisual;
	
	public Player()
	{
		playerLogic = new PlayerLogic();
		playerVisual = new PlayerVisual();
	}
	
	public String getName()
	{
		return playerLogic.name;
	}
	
	public void setName(String newName)
	{
		playerLogic.name = newName;
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
	
}
