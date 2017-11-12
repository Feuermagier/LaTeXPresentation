package firemage.latexpres.core;

public interface ISection extends Displayable {
	
	default boolean isSlide() {
		return false;
	}
	
	public String getCommand();
	public int getDepth();
}
