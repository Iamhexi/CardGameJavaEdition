package cards;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;

/*
	GOALS:
	- write unit tests
	- create PlayerVisual layout
	- develop GameInterface and organise basic game layout, delegating it from Main
*/

public class Main 
{
	private static Integer i = 0;
	
	public static void main(String[] args)
	{
		System.setProperty("awt.useSystemAAFontSettings","on");	
		JFrame frame = new JFrame();
		
		try {
			//Card c1 = new Card("assets/card.png", new Vector2i(0, 0));
			//Card c2 = new Card("assets/card.png", new Vector2i(0, 0));
			//frame.add(c1.cardVisual);
			//frame.add(c2.cardVisual);

			Player p = new Player("Joe", 50, "assets/card.png", new Vector2i(1920/2 - 200, 1080-400));
			frame.add(p.getPlayerVisual());
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		
		
		frame.setSize(1920, 1080);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}
