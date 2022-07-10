package cards;

class CardLogic {
	protected int id;

	protected Runnable onDiscard; // effect invoked whilst the card is being discarded
	protected Runnable onPlay;
	protected Runnable onDraw;
	protected Runnable onResurrect; // effect invoked whilst the card is being moved from discard zone to hand

	public static int idCounter = 0;
	protected CardLocation location = CardLocation.Deck;

	public void discard() {
		onDiscard.run();
		location = CardLocation.DiscardZone;
	}

	public void play() {
		onPlay.run();
		location = CardLocation.Battlefield;
	}

	public void draw() {
		onDraw.run();
		location = CardLocation.Hand;
	}

	public void resurrect() {
		onResurrect.run();
		location = CardLocation.Hand;
	}

	public CardLogic() {
		id = idCounter++;
	}

	public CardLocation getLocation() {
		return location;
	}

	public void setOnDiscard(Runnable onDiscard) {
		this.onDiscard = onDiscard;
	}

	public void setOnPlay(Runnable onPlay) {
		this.onPlay = onPlay;
	}

	public void setOnDraw(Runnable onDraw) {
		this.onDraw = onDraw;
	}

	public void setOnResurrect(Runnable onResurrect) {
		this.onResurrect = onResurrect;
	}

	public int getId() {
		return id;
	}

}
