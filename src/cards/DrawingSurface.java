package cards;

import java.awt.*;
import javax.swing.*;

public class DrawingSurface extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(new Color(0, 0, 0));
		
		g.drawLine(20, 20, 400, 400);
		
	}
}
