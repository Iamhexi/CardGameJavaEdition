package cards;

import java.awt.*;

import javax.swing.*;

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
		
		JLabel label = new JLabel();
		label.setBounds(new Rectangle(600, 200, 150, 50));
		label.setText("Card title ;) very soon");
		frame.add(label);
		
		frame.setTitle("Cards");
		frame.setSize(1000, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		Card c = new SpellCard();
		c.setOnDiscard( () -> { System.out.println("I'm discarded :>");  } );
		
		
	}
}
