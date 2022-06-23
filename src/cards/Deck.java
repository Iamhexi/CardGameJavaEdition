package cards;

import java.util.*;

public class Deck
{
	private LinkedList<CardLogic> cards;
	
	public Deck()
	{
		cards = new LinkedList<CardLogic>();
	}
	
	public int countCards(CardLocation location)
	{
		int counter = 0;
		for (CardLogic card: cards)
			if (card.location == location)
				counter++;
		
		return counter;
	}
	
	public void moveRandomCard(CardLocation from, CardLocation to)
	{
		for (CardLogic card: cards)
			if (card.location == from)
				card.location = to;
		// TODO it cannot operate directly on location
	}
	
	public void moveCard(int cardId, CardLocation from, CardLocation to)
	{
		for (CardLogic card: cards)
			if (card.getId() == cardId && card.location == from)
				card.location = to;
	}
	
	public void moveCard(int cardId,  CardLocation to)
	{
		for (CardLogic card: cards)
			if (card.getId() == cardId)
				card.location = to;
	}
	
	
}
