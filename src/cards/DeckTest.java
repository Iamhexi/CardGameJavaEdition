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
			Card card = new Card("Card title", "assets/card.png", new Vector2i(0,0));
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
			Card card = new Card("Card title", "assets/card.png", new Vector2i(0,0));
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
			String cardTitle = "this";
			JFrame frame = new JFrame();
			Card card = new Card(cardTitle, "assets/card.png", new Vector2i(0,0));
			Deck deck = new Deck(frame);
			
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
			Card card = new Card("haha", "assets/card.png", new Vector2i(0,0));
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
			String cardTitle = "this";
			JFrame frame = new JFrame();
			Card card = new Card(cardTitle, "assets/card.png", new Vector2i(0,0));
			Deck deck = new Deck(frame);
			
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
			Card card = new Card("title", "assets/card.png", new Vector2i(0,0));
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
			String cardTitle = "this";
			JFrame frame = new JFrame();
			Card card = new Card(cardTitle, "assets/card.png", new Vector2i(0,0));
			Deck deck = new Deck(frame);
			
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
			Card card = new Card("title", "assets/card.png", new Vector2i(0,0));
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
