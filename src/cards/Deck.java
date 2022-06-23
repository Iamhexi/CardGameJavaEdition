package cards;

import java.util.*;

public class Deck
{
	private LinkedList<Card> cards;
	
	public Deck()
	{
		cards = new LinkedList<Card>();
	}
	
	public int countCards(CardLocation location)
	{
		int counter = 0;
		for (Card card: cards)
			if (card.location == location)
				counter++;
		
		return counter;
	}
	
	public void moveRandomCard(CardLocation from, CardLocation to)
	{
		for (Card card: cards)
			if (card.location == from)
				card.location = to;
	}
	
	public void moveCard(int cardId, CardLocation from, CardLocation to)
	{
		for (Card card: cards)
			if (card.getId() == cardId && card.location == from)
				card.location = to;
	}
	
	public void moveCard(int cardId,  CardLocation to)
	{
		for (Card card: cards)
			if (card.getId() == cardId)
				card.location = to;
	}
	
	
}
