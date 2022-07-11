package cards;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class CardTest {

	@Test
	void testPlay() 
	{
		Card card;
		try {
			CardDirector director = new CardDirector();
			card = director.createExample();
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
			CardDirector director = new CardDirector();
			card = director.createExample();
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
			CardDirector director = new CardDirector();
			card = director.createExample();
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
			CardDirector director = new CardDirector();
			card = director.createExample();
			
			card.draw();
			
			assertEquals( CardLocation.Hand, card.getLocation() );
			
		} catch (Exception e) {
			fail("Could not an instance of a card.");
		}
	}

}
