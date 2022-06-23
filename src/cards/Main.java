package cards;

import java.awt.*;
import javax.swing.*;

/*
	GOALS:
	- make drawing a card possible (fixes in Deck and other classes),
	- write unit tests
	- create CardVisual layout
	- create PlayerVisual layout
	- develop GameInterface and organise basic game layout, delegating it from Main
*/


public class Main 
{
	public static void main(String[] args)
	{
		System.setProperty("awt.useSystemAAFontSettings","on");	
		JFrame frame = new JFrame();
		
		JButton button = new JButton("Press me");
		button.setBounds(200, 200, 200, 200);
		frame.add(button);
		
		DrawingSurface surface = new DrawingSurface();
		surface.setBounds(0, 0, 500, 500);
		frame.add(surface);
		
		frame.setTitle("Cards");
		frame.setSize(1000, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		GameManager manager = new DuelManager();
		Player p1 = new Player();
		p1.setName("Johnny");
		
		JLabel label = new JLabel();
		label.setBounds(new Rectangle(600, 200, 150, 50));
		label.setText(p1.getName());
		frame.add(label);
		
		CardLogic.setGameManager(manager);
		CardLogic c = new SpellCard();
		c.setOnPlay( () -> { manager.enemyTakesDamage(2);  } );
		c.play();
		
		
	}
}
