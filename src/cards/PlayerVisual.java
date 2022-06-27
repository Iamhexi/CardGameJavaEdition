package cards;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

final class PlayerVisual extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel name;
	private JLabel picture;
	private BufferedImage img;
	
	private int playerWidth = 400;
	private int pictureHeight = 400;
	private int nameHeight = 75;
	
	public PlayerVisual()
	{
		picture = new JLabel();
		name = new JLabel();
	}
	
	public PlayerVisual(String name, String pathToPicture, Vector2i location) throws IOException
	{
		this.name = new JLabel();
		this.name.setText(name);
		
		loadPictureFromFile(pathToPicture);
		configureNameAppearance();
		setLocationsAndSizes(location);
		
		this.add(this.picture);
		this.add(this.name);
	}
	
	private void configureNameAppearance()
	{
		name.setFont(new Font(Font.SERIF, Font.BOLD, 35));
	}
	
	private void loadPictureFromFile(String pathToFile) throws IOException
	{
		img = ImageIO.read( new File(pathToFile) );
		picture = new JLabel(new ImageIcon(img));
	}
	
	private void setLocationsAndSizes(Vector2i location)
	{
		int playerHeight = pictureHeight + nameHeight;
		this.setBounds(location.x, location.y, playerWidth, playerHeight);
		picture.setBounds(location.x, location.y, playerWidth, pictureHeight);
		name.setBounds(location.x, location.y + pictureHeight, playerWidth, nameHeight);
	}
	
	public String getName()
	{
		return name.getText();
	}
	

	public void playDrawCardAnimation() 
	{
		// TODO Auto-generated method stub
	}

	public void playHealDamageAnimation(int amount) 
	{
		// TODO Auto-generated method stub
	}

	public void playTakeDamageAnimation(int amount) 
	{
		// TODO Auto-generated method stub
	}
	
}
