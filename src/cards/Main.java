package cards;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;

/*
	GOALS:
	- make a card draggable
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
			Card c = new Card("assets/card.png", new Vector2i(0, 0));
			frame.add(c.cardVisual);

		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		frame.setSize(1000, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}
