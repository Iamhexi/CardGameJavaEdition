package cards;

import java.io.IOException;

public class CardBuilder 
	{
		private CardLogic cardLogic = new CardLogic();
		private CardVisual cardVisual = new CardVisual();
		
		CardBuilder visualLocation(Vector2i location)
		{
			this.cardVisual.location = location;
			return this;
		}
		
		CardBuilder logicalLocation(CardLocation location)
		{
			this.cardLogic.location = location;
			return this;
		}
		
		CardBuilder title(String title)
		{
			try {
				this.cardVisual.setTitle(title);
				return this;
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return this;
		}
		
		CardBuilder description(String description)
		{
			cardVisual.description.setText(description);
			return this;
		}
		
		CardBuilder pathToPicture(String path)
		{
			cardVisual.pathToPicture = path;
			return this;
		}
		
		CardBuilder onDiscard(Runnable action)
		{
			cardLogic.onDiscard = action;
			return this;
		}
		
		CardBuilder onPlay(Runnable action)
		{
			cardLogic.onPlay = action;
			return this;
		}
		
		CardBuilder onResurrect(Runnable action)
		{
			cardLogic.onResurrect = action;
			return this;
		}
		
		CardBuilder onDraw(Runnable action)
		{
			cardLogic.onDraw = action;
			return this;
		}
		
		Card build() throws Exception
		{
			return new Card(
				cardVisual.title.getText(),
				cardVisual.description.getText(),
				cardVisual.pathToPicture,
				new Vector2i ( cardVisual.getLocation().x, cardVisual.getLocation().y ),
				cardLogic.location,
				cardLogic.onPlay,
				cardLogic.onDiscard,
				cardLogic.onResurrect,
				cardLogic.onDraw				
			);
		}
	}