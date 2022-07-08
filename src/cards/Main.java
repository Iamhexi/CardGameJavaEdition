package cards;


import javax.swing.*;

/*
	GOALS:
	- handle the deck as a pile of cards: organise card positions
	- write unit tests
	- develop GameInterface and organise basic game layout, delegating it from Main
*/

public class Main 
{
	static CardDatabase db = new CardDatabase();
	
	public static void main(String[] args)
	{
		System.setProperty("awt.useSystemAAFontSettings","on");	
		JFrame frame = new JFrame();
		
		db.createCard( 
			new CardBlueprintData(
				"The first card",
				"Show me what you got, haha!",
				"assets/card.png",
				() -> { System.out.println("You are great, good boi!");  },
				() -> {},
				() -> {},
				() -> {}
			)
		);
		
		try {
			Player player = new Player("Player", 50, "assets/confused_guy.png", new Vector2i(1920/2 - 200, 1080-400), frame);
			
			player.addCardToDeck( db.get("The first card") );
			player.addCardToDeck( db.get("The first card") );
			
			player.initialise(frame);

			
			Player enemy = new Player("Enemy", 50, "assets/confused_guy.png", new Vector2i(1920/2 - 200, 0), frame);
			
			
			
			enemy.initialise(frame);
			
			//enemy.addCardToDeck( db.get("The first card") );
			
			DuelManager duelManager = new DuelManager(player, enemy);

			
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
