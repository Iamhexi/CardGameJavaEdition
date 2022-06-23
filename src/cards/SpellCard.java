package cards;

public class SpellCard extends Card 
{
	public SpellCard()
	{
		super();
	}

	@Override
	public void onDiscard()
	{
		try {
			onDiscard.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onPlay() {
		
		try {
			onPlay.run();
			location = CardLocation.DiscardZone;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onDraw() {
		try {
			onDraw.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onResurrect() {
		try {
			onResurrect.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
