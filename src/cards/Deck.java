package cards;

import java.util.*;

import javax.swing.JFrame;

public class Deck
{
	private LinkedList<Card> cards;
	private JFrame mainFrame;
	
	public Deck()
	{
		cards = new LinkedList<Card>();
	}
	
	public Deck(JFrame frame)
	{
		cards = new LinkedList<Card>();
		mainFrame = frame;
	}
	
	public void addCard(Card card)
	{
		card.initialise(mainFrame);
		cards.add(card);
	}
	
	public int countCards(CardLocation location)
	{
		int counter = 0;
		for (Card card: cards)
			if (card.getLocation() == location)
				counter++;
		
		return counter;
	}
	
	private Card getRandomCard(CardLocation location)
	{
		LinkedList<Card> cardsInLocation = new LinkedList<Card>();
		for (Card card: cards)
			if (card.getLocation() == location)
				cardsInLocation.add(card);
		
		int upperBound = cardsInLocation.size();
		Random rndGenerator = new Random();
		
		return cardsInLocation.get( rndGenerator.nextInt(upperBound) );
	}
	
	public void discardRandom()
	{
		getRandomCard(CardLocation.Hand).discard();
	}
	
	public void discard(String cardTitle)
	{
		for (Card card: cards)
			if (card.getTitle() == cardTitle)
				card.discard();
	}
	
	public void drawRandom()
	{
		getRandomCard(CardLocation.Deck).draw();
	}
	
	public void draw(String cardTitle)
	{
		for (Card card: cards)
			if (card.getTitle() == cardTitle)
				card.draw();
	}
	
	public void playRandom()
	{
		getRandomCard(CardLocation.Deck).play();
	}
	
	public void play(String cardTitle)
	{
		for (Card card: cards)
			if (card.getTitle() == cardTitle)
				card.play();
	}
	
	
}
