package cards;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DuelManager implements GameManager {
	protected Player player1;
	protected Player player2;

	protected Player currentPlayer;

	public DuelManager(Player player, Player enemy, JFrame frame) {
		player1 = player;
		player2 = enemy;
		
		player1.initialise(frame);
		player2.initialise(frame);
		
		currentPlayer = player1;
	}

	@Override
	public void drawCard() {
		currentPlayer.drawCard();
	}

	@Override
	public void takeDamage(int amount) {
		currentPlayer.takeDamage(amount);
	}

	@Override
	public void healDamage(int amount) {
		currentPlayer.healDamage(amount);
	}

	@Override
	public void enemyTakesDamage(int amount) {
		if (currentPlayer.hashCode() == player1.hashCode())
			player2.takeDamage(amount);
		else
			player1.takeDamage(amount);
	}

	@Override
	public void enemyHealsDamage(int amount) {
		if (currentPlayer.hashCode() == player1.hashCode())
			player2.healDamage(amount);
		else
			player1.healDamage(amount);
	}

	@Override
	public void enemyDrawsCard() {
		if (currentPlayer.hashCode() == player1.hashCode())
			player2.drawCard();
		else
			player1.drawCard();
	}

	@Override
	public void endTurn() {
		if (currentPlayer.hashCode() == player1.hashCode())
			currentPlayer = player2;
		else
			currentPlayer = player1;
	}

	@Override
	public void finishGame(Player winner, Player loser) {
		this.announceResults(winner, loser);
		// TODO Play conffetti animation
	}

	private void announceResults(Player winner, Player loser) {
		JOptionPane.showMessageDialog(null, winner.getName() + " has won the game, congratulations!", "The game result",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
