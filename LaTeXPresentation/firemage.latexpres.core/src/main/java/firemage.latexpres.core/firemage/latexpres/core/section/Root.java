package firemage.latexpres.core.section;

import firemage.latexpres.core.ISection;

public class Root implements ISection {
	private String title;
	private String id;

	public Root(String title) {
		this.title = title;
	}

	@Override
	public String getTextToDisplay() {
		return title;
	}

	@Override
	public void setDisplayedText(String text) {
		this.title = text;
	}

	@Override
	public String getCommand() {
		return "";
	}

	@Override
	public int getDepth() {
		return 0;
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
