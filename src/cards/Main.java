package cards;


import javax.swing.*;

/*
	GOALS:
	- rethink how to invoke playing a card (from player's perspective or duel manager?)
	- make it possible to discard/resurrect/play a card (as it is possible to draw a card)
	- handle the deck as a pile of cards: organise card positions
	- write unit tests
	- develop GameInterface and organise basic game layout, delegating it from Main
*/

public class Main 
{	
	public static void main(String[] args)
	{
		System.setProperty("awt.useSystemAAFontSettings","on");	
		JFrame frame = new JFrame();
		
		CardDirector director = new CardDirector(); 
		CardVisual.frame = frame;
		
		try {
			Player player = new Player("Player", 50, "assets/confused_guy.png", new Vector2i(1920/2 - 200, 1080-400), frame);
			
			player.addCardToDeck( director.createExample() );
			player.addCardToDeck( director.createExample() );
			player.addCardToDeck( director.createExample() );

			
			
			Player enemy = new Player("Enemy", 50, "assets/confused_guy.png", new Vector2i(1920/2 - 200, 0), frame);
			
			//enemy.addCardToDeck( db.get("The first card") );
			
			DuelManager duelManager = new DuelManager(player, enemy, frame);
			
			//duelManager.drawCard();
			//duelManager.drawCard();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		
		
		frame.setSize(1920, 1080);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("The Card Game");
		
	}
}
