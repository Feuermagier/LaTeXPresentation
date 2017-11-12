package firemage.latexpres.core;

import javafx.scene.Node;

public interface ISlide {
	default boolean isSlide() {
		return true;
	}

	public SlideType getSlideType();

	public Node getEditorComponent();

	public boolean isDisplayed();

	public void setDisplayed(boolean displayed);

	public String getTitle();

	public void setDisabled(boolean disabled);
}
