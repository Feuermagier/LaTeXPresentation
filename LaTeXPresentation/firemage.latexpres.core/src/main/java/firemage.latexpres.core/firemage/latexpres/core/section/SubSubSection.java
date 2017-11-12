package firemage.latexpres.core.section;

import firemage.latexpres.core.ISection;

public class SubSubSection implements ISection {
	private String title;
	private String textToDisplay;
	private String id;

	public SubSubSection(String title) {
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
		return "\\subsubsection{" + title + "}";
	}

	@Override
	public int getDepth() {
		return 3;
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
