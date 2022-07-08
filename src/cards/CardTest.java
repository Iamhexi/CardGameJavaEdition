package cards;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class CardTest {

	@Test
	void testPlay() 
	{
		Card card;
		try {
			card = new Card("title", "assets/confused_guy.png", new Vector2i ( 0, 0 ) );
			card.draw();
			
			card.play();
			
			assertEquals( CardLocation.Battlefield, card.getLocation() );
			
		} catch (Exception e) {
			fail("Could not an instance of a card.");
		}
	}

	@Test
	void testDiscard() 
	{
		Card card;
		try {
			card = new Card("title", "assets/confused_guy.png", new Vector2i ( 0, 0 ) );
			card.draw();
			
			card.discard();
			
			assertEquals( CardLocation.DiscardZone, card.getLocation() );
			
		} catch (Exception e) {
			fail("Could not an instance of a card.");
		}
		
	}

	@Test
	void testResurrect() 
	{
		Card card;
		try {
			card = new Card("title", "assets/confused_guy.png", new Vector2i ( 0, 0 ) );
			card.draw();
			
			card.resurrect();
			
			assertEquals( CardLocation.Hand, card.getLocation() );
			
		} catch (Exception e) {
			fail("Could not an instance of a card.");
		}
	}

	@Test
	void testDraw() {
		Card card;
		try {
			card = new Card("title", "assets/confused_guy.png", new Vector2i ( 0, 0 ) );
			
			card.draw();
			
			assertEquals( CardLocation.Hand, card.getLocation() );
			
		} catch (Exception e) {
			fail("Could not an instance of a card.");
		}
	}

}
