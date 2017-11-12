package firemage.latexpres.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.commands.Action;
import de.saxsys.mvvmfx.utils.commands.Command;
import de.saxsys.mvvmfx.utils.commands.DelegateCommand;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MainViewModel implements ViewModel {

	private static final Logger log = LogManager.getLogger(MainViewModel.class);

	private Command loadCommand;
	private BooleanProperty loadingEnabled = new SimpleBooleanProperty(true);

	private Command saveCommand;
	private BooleanProperty savingEnabled = new SimpleBooleanProperty(false);
	
	private Command saveAtCommand;
	private BooleanProperty savingAtEnabled = new SimpleBooleanProperty(false);

	private Command newPresentationCommand;
	private BooleanProperty newPresentationEnabled = new SimpleBooleanProperty(true);

	private Command parseCommand;
	private BooleanProperty parsingEnabled = new SimpleBooleanProperty(false);

	private Command addSectionCommand;
	private BooleanProperty addSectionEnabled = new SimpleBooleanProperty(false);

	private Command addSlideCommand;
	private BooleanProperty addSlideEnabled = new SimpleBooleanProperty(false);
	
	private Command removeCommand;
	private BooleanProperty removeEnabled = new SimpleBooleanProperty(false);
	
	private Command exitCommand;
	private BooleanProperty exitEnabled = new SimpleBooleanProperty(true);
	
	private StringProperty outputString = new SimpleStringProperty();
	private BooleanProperty backgroundOperationProperty = new SimpleBooleanProperty(false);

	public MainViewModel() {
		initLoad();
		initAddSection();
		initAddSlide();
		initNewPresentation();
		initParse();
		initRemove();
		initSave();
		initSaveAt();
		initExit();
	}

	// Load
	private void initLoad() {

		final Action action = new Action() {
			@Override
			protected void action() throws Exception {
				load();
			}
		};
		action.runningProperty().addListener((o, ov, nv) -> backgroundOperationProperty.set(nv));
		action.messageProperty().addListener((o, ov, nv) -> outputString.set(nv));
		loadCommand = new DelegateCommand(() -> action, loadingEnabled, true);

	}

	public Command getLoadCommand() {
		return loadCommand;
	}

	public BooleanProperty loadingEnabledProperty() {
		return loadingEnabled;
	}

	private void load() {
		// TODO: Implement load
	}

	// Save
	private void initSave() {
		final Action action = new Action() {
			@Override
			protected void action() throws Exception {
				save();
			}
		};
		action.runningProperty().addListener((o, ov, nv) -> backgroundOperationProperty.set(nv));
		action.messageProperty().addListener((o, ov, nv) -> outputString.set(nv));
		saveCommand = new DelegateCommand(() -> action, savingEnabled, true);
	}

	public Command getSaveCommand() {
		return saveCommand;
	}

	public BooleanProperty savingEnabledProperty() {
		return savingEnabled;
	}

	private void save() {
		// TODO: Implement save
	}
	
	// Save at...
	private void initSaveAt() {
		final Action action = new Action() {
			@Override
			protected void action() throws Exception {
				saveAt();
			}
		};
		action.runningProperty().addListener((o, ov, nv) -> backgroundOperationProperty.set(nv));
		action.messageProperty().addListener((o, ov, nv) -> outputString.set(nv));
		saveAtCommand = new DelegateCommand(() -> action, savingAtEnabled, true);
	}

	public Command getSaveAtCommand() {
		return saveAtCommand;
	}

	public BooleanProperty savingAtEnabledProperty() {
		return savingAtEnabled;
	}

	private void saveAt() {
		// TODO: Implement save at...
	}

	// New Presentation
	private void initNewPresentation() {
		newPresentationCommand = new DelegateCommand(() -> new Action() {
			@Override
			protected void action() throws Exception {
				newPresentation();
			}
		}, newPresentationEnabled, false);
	}

	public Command getNewPresentationCommand() {
		return newPresentationCommand;
	}

	public BooleanProperty newPresentationEnabledProperty() {
		return newPresentationEnabled;
	}

	private void newPresentation() {
		// TODO: Implement new presentation
	}

	// Parse
	private void initParse() {
		final Action action = new Action() {
			@Override
			protected void action() throws Exception {
				save();
			}
		};
		action.runningProperty().addListener((o, ov, nv) -> backgroundOperationProperty.set(nv));
		action.messageProperty().addListener((o, ov, nv) -> outputString.set(nv));
		parseCommand = new DelegateCommand(() -> action, parsingEnabled, true);
	}

	public Command getParseCommand() {
		return parseCommand;
	}

	public BooleanProperty parseEnabledProperty() {
		return parsingEnabled;
	}

	private void parse() {
		// TODO: Implement parse
	}

	// Add section
	private void initAddSection() {
		addSectionCommand = new DelegateCommand(() -> new Action() {
			@Override
			protected void action() throws Exception {
				addSection();
			}
		}, addSectionEnabled, false);
	}

	public Command getAddSectionCommand() {
		return addSectionCommand;
	}

	public BooleanProperty addSectionEnabledProperty() {
		return addSectionEnabled;
	}

	private void addSection() {
		// TODO: Implement add section
	}

	// Add slide
	private void initAddSlide() {
		addSlideCommand = new DelegateCommand(() -> new Action() {
			@Override
			protected void action() throws Exception {
				addSlide();
			}
		}, addSectionEnabled, false);
	}

	public Command getAddSlideCommand() {
		return addSlideCommand;
	}

	public BooleanProperty addSlideEnabledProperty() {
		return addSlideEnabled;
	}

	private void addSlide() {
		// TODO: Implement add slide
	}
	
	// Remove
	private void initRemove() {
		removeCommand = new DelegateCommand(() -> new Action() {
			@Override
			protected void action() throws Exception {
				remove();
			}
		}, removeEnabled, false);
	}

	public Command getRemoveCommand() {
		return removeCommand;
	}

	public BooleanProperty removeEnabledProperty() {
		return removeEnabled;
	}

	private void remove() {
		// TODO: Implement remove
	}
	
	// Exit
	private void initExit() {
		exitCommand = new DelegateCommand(() -> new Action() {
			@Override
			protected void action() throws Exception {
				exit();
			}
		}, exitEnabled, false);
	}

	public Command getExitCommand() {
		return exitCommand;
	}

	public BooleanProperty exitEnabledProperty() {
		return exitEnabled;
	}

	private void exit() {
		System.exit(0);
	}
	
	
	// Output string
	public void addLineToOutputString(String str) {
		outputString.set(outputString.get() + "\n" + str);
	}
	
	public void clearOutputString() {
		outputString.set("");
	}
	
	public StringProperty outputStringProperty() {
		return outputString;
	}
	
	//Background operation
	public BooleanProperty backgroundOperationProperty() {
		return backgroundOperationProperty;
	}
}
