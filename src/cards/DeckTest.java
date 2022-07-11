package cards;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testAddCard() 
	{
		try {
			JFrame frame = new JFrame();
			CardDirector director = new CardDirector();
			Card card = director.createExample();
			Deck deck = new Deck(frame);
			
			deck.addCard(card);
			
			assertEquals(1, deck.countCards(CardLocation.Deck)); // The default cards' location is Deck
		} catch (Exception e) {
			System.out.println(e);
			fail("Card constructor thrown exception.");
		}
	}

	@Test
	void testDiscardRandom() 
	{
		try {
			JFrame frame = new JFrame();
			CardDirector director = new CardDirector();
			Card card = director.createExample();
			Deck deck = new Deck(frame);
			
			deck.addCard(card);
			deck.drawRandom(); // The default cards' location is Deck
			deck.discardRandom();
			
			assertEquals(1, deck.countCards(CardLocation.DiscardZone)); 
		} catch (Exception e) {
			System.out.println(e);
			fail("Card constructor thrown exception.");
		}
	}

	@Test
	void testDiscard() 
	{
		try {
			JFrame frame = new JFrame();
			CardDirector director = new CardDirector();
			Card card = director.createExample();
			Deck deck = new Deck(frame);
			String cardTitle = card.getTitle();
			
			deck.addCard(card);
			deck.discard(cardTitle); // The default cards' location is Deck
			
			assertEquals(1, deck.countCards(CardLocation.DiscardZone));
		} catch (Exception e) {
			System.out.println(e);
			fail("Card constructor thrown exception.");
		}
	}

	@Test
	void testDrawRandom() 
	{
		try {
			JFrame frame = new JFrame();
			CardDirector director = new CardDirector();
			Card card = director.createExample();
			Deck deck = new Deck(frame);
			
			deck.addCard(card);
			deck.drawRandom(); // The default cards' location is Deck
			
			assertEquals(1, deck.countCards(CardLocation.Hand)); 
		} catch (Exception e) {
			System.out.println(e);
			fail("Card constructor thrown exception.");
		}
	}

	@Test
	void testDraw() 
	{
		try {
			JFrame frame = new JFrame();
			CardDirector director = new CardDirector();
			Card card = director.createExample();
			Deck deck = new Deck(frame);
			String cardTitle = card.getTitle();
			
			deck.addCard(card);
			deck.draw(cardTitle); // The default cards' location is Deck
			
			assertEquals(1, deck.countCards(CardLocation.Hand));
		} catch (Exception e) {
			System.out.println(e);
			fail("Card constructor thrown exception.");
		}
	}

	@Test
	void testPlayRandom() 
	{
		try {
			JFrame frame = new JFrame();
			CardDirector director = new CardDirector();
			Card card = director.createExample();
			Deck deck = new Deck(frame);
			
			deck.addCard(card);
			deck.drawRandom(); // The default cards' location is Deck
			deck.playRandom();
			
			assertEquals(1, deck.countCards(CardLocation.Battlefield));
		} catch (Exception e) {
			System.out.println(e);
			fail("Card constructor thrown exception.");
		}	}

	@Test
	void testPlayString() 
	{
		try {
			JFrame frame = new JFrame();
			CardDirector director = new CardDirector();
			Card card = director.createExample();
			Deck deck = new Deck(frame);
			String cardTitle = card.getTitle();
			
			deck.addCard(card);
			deck.draw(cardTitle); // The default cards' location is Deck
			deck.play(cardTitle);
			
			assertEquals(1, deck.countCards(CardLocation.Battlefield));
		} catch (Exception e) {
			System.out.println(e);
			fail("Card constructor thrown exception.");
		}
	}

	@Test
	void testPlayInt() 
	{
		try {
			JFrame frame = new JFrame();
			CardDirector director = new CardDirector();
			Card card = director.createExample();
			Deck deck = new Deck(frame);
			int id = card.getId();
			
			deck.addCard(card);
			deck.drawRandom(); // The default cards' location is Deck
			deck.play(id);
			
			assertEquals(1, deck.countCards(CardLocation.Battlefield)); 
		} catch (Exception e) {
			System.out.println(e);
			fail("Card constructor thrown exception.");
		}
	}

}
