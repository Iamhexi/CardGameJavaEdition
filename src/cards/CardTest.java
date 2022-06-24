package cards;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class CardTest {

	@Test
	void testPlay() 
	{
		Card card = new Card();
		card.draw();
		
		card.play();
		
		assertEquals( CardLocation.Battlefield, card.getLocation() );
	}

	@Test
	void testDiscard() 
	{
		Card card = new Card();
		card.draw();
		
		card.discard();
		
		assertEquals( CardLocation.DiscardZone, card.getLocation() );
	}

	@Test
	void testResurrect() 
	{
		Card card = new Card();
		card.draw();
		card.discard();
		
		card.resurrect();
		
		assertEquals( CardLocation.Hand, card.getLocation() );
	}

	@Test
	void testDraw() {
		Card card = new Card();
	
		card.draw();
		
		assertEquals( CardLocation.Hand , card.getLocation() );	
	}

}
