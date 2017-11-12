package firemage.latexpres.core;

public interface Displayable {

	public String getTextToDisplay();

	public void setDisplayedText(String text);

	public boolean isSlide();

	public String getId();

	public void setId(String id);
}
