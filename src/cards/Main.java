package cards;


import javax.swing.*;

/*
	GOALS:
	- handle the deck as a pile of cards
	- write unit tests
	- develop GameInterface and organise basic game layout, delegating it from Main
*/

public class Main 
{
	public static void main(String[] args)
	{
		System.setProperty("awt.useSystemAAFontSettings","on");	
		JFrame frame = new JFrame();
		
		try {
			Player enemy = new Player("Enemy", 50, "assets/confused_guy.png", new Vector2i(1920/2 - 200, 0), frame);
			Player player = new Player("Player", 50, "assets/confused_guy.png", new Vector2i(1920/2 - 200, 1080-400), frame);
			
			player.addCardToDeck( new Card( "assets/card.png", new Vector2i( 200, 600 ) ) );
			
			enemy.initialise(frame);
			player.initialise(frame);
			
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
