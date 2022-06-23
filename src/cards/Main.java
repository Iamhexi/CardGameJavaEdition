package cards;


import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.*;

/*
	GOALS:
	- make drawing a card possible (fixes in Deck and other classes),
	- write unit tests
	- create CardVisual layout
	- create PlayerVisual layout
	- develop GameInterface and organise basic game layout, delegating it from Main
*/

class MyPanel extends JPanel {

    

	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	      g.setColor(Color.YELLOW);
	      g.fillOval(10, 10, 200, 200);
	      // draw Eyes
	      g.setColor(Color.BLACK);
	      g.fillOval(55, 65, 30, 30);
	      g.fillOval(135, 65, 30, 30);
	      // draw Mouth
	      g.fillOval(50, 110, 120, 60);
	      // adding smile
	      g.setColor(Color.YELLOW);
	      g.fillRect(50, 110, 120, 30);
    }
}

public class Main 
{
	public static void main(String[] args)
	{
		System.setProperty("awt.useSystemAAFontSettings","on");	
		JFrame frame = new JFrame();
		MyPanel p = new MyPanel();
		p.setBounds(0, 0, 200, 200);
		
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
