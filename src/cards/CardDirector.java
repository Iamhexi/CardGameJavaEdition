package cards;

public class CardDirector 
{		
	public Card createExample()
	{	
		try {
			CardBuilder builder = new CardBuilder();
			return builder
				.title("An example")
				.pathToPicture("assets/card.png")
				.description("This is an example of a card used for development purposes only.")
				.logicalLocation(CardLocation.Deck)
				.visualLocation( new Vector2i(0, 0) )
				.onPlay( () -> { System.out.println("Example has been played."); } )
				.onDiscard( () -> {} )
				.onResurrect( () -> {} )
				.onDraw( () -> {} )
			.build();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}

}
