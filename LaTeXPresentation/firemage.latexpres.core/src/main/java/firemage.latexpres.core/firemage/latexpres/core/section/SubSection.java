package firemage.latexpres.core.section;

import firemage.latexpres.core.ISection;

public class SubSection implements ISection {
	private String title;
	private String textToDisplay;
	private String id;

	public SubSection(String title) {
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
		return "\\subsection{" + title + "}";
	}

	@Override
	public int getDepth() {
		return 2;
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
