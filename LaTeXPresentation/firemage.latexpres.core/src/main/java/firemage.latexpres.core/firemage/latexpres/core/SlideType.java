package firemage.latexpres.core;

public enum SlideType {
	LATEX_SLIDE("latex"), JAVA_ANIMATED_SLIDE("java-animated");

	private String command;

	private SlideType(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
}
