package cards;

public class CardBlueprintData 
{
	public String title;
	public String description;
	public String pictureLocation;
	public Runnable onPlay;
	public Runnable onDiscard;
	public Runnable onDraw;
	public Runnable onResurrect;

	CardBlueprintData(String title,
		String description,
		String pictureLocation,
		Runnable onPlay,
		Runnable onDiscard,
		Runnable onRessurect,
		Runnable onDraw)
	{
		this.title = title;
		this.description = description;
		this.pictureLocation = pictureLocation;
		this.onPlay = onPlay;
		this.onDiscard = onDiscard;
		this.onResurrect = onRessurect;
		this.onDraw = onDraw;
	}
}
