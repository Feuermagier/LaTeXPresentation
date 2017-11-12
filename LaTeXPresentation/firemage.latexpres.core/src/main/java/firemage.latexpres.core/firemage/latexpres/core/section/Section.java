package firemage.latexpres.core.section;

import firemage.latexpres.core.ISection;

public class Section implements ISection {
	String title;
	String textToDisplay;
	String id;
	
	public Section(String title) {
		this.title = title;
		textToDisplay = title;
	}
	
	@Override
	public String getTextToDisplay() {
		return textToDisplay;
	}

	@Override
	public void setDisplayedText(String text) {
		this.textToDisplay = text;

	}

	@Override
	public String getCommand() {
		return "\\section{" + title + "}";
	}

	@Override
	public int getDepth() {
		return 1;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
