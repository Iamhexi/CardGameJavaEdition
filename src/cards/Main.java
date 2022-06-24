package cards;


import java.io.IOException;

import javax.swing.*;

/*
	GOALS:
	- make drawing a card possible (fixes in Deck and other classes),
	- write unit tests
	- create PlayerVisual layout
	- develop GameInterface and organise basic game layout, delegating it from Main
*/

public class Main 
{
	public static void main(String[] args)
	{
		System.setProperty("awt.useSystemAAFontSettings","on");	
		JFrame frame = new JFrame();
		
		try {
			Card c = new Card("assets/card.png", new Vector2i(0, 0));
			frame.add(c.cardVisual);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		frame.setTitle("Cards");
		frame.setSize(1000, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}
