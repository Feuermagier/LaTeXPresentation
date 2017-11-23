package firemage.latexpres.core;

import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class PresentationRepository implements Observable {

	private static PresentationRepository instance;
	private ArrayList<InvalidationListener> listeners;

	private Presentation currentPresentation;
	private int registerCounter = 0;

	private PresentationRepository() {

	}

	public static PresentationRepository getInstance() {
		if (instance == null) {
			instance = new PresentationRepository();
		}

		return instance;
	}

	public void loadPresentation(String path) {

	}

	public void savePresentation() {

	}

	public Presentation getCurrentPresentation() {
		return currentPresentation;
	}
	
	public int registerElement() {
		registerCounter++;
		return registerCounter;
	}

	@Override
	public void addListener(InvalidationListener arg0) {
		listeners.add(arg0);
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		listeners.remove(arg0);
	}
}
