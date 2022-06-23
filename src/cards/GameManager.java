package cards;

public interface GameManager 
{
	void endTurn();
	void finishGame(Player winner, Player loser);
	void takeDamage(int amount);
	void healDamage(int amount);
	void drawCard();
	void enemyTakesDamage(int amount);
	void enemyHealsDamage(int amount);
	void enemyDrawsCard(); 
}
