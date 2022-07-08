package cards;

import java.util.HashMap;

public class CardDatabase 
{
	private HashMap<String, CardBlueprintData> prototypes = new HashMap<String, CardBlueprintData>();
	
	public void createCard(CardBlueprintData prototype)
	{
		prototypes.put(prototype.title, prototype);
	}
	
	public Card get(String cardTitle) throws Exception
	{
		CardBlueprintData prototype = prototypes.get(cardTitle);
		Card c = new Card(prototype.title, prototype.pictureLocation, new Vector2i(0,0) );
		c.setDescription(prototype.description);
		
		c.setOnPlay(prototype.onPlay);
		c.setOnDiscard(prototype.onDiscard);
		c.setOnResurrect(prototype.onResurrect);
		c.setOnDiscard(prototype.onDiscard);
		
		return c;
	}

}
