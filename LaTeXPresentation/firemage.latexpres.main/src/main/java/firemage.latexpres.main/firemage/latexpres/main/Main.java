package firemage.latexpres.main;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import firemage.latexpres.view.MainView;
import firemage.latexpres.view.MainViewModel;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("LaTeX Presentation Editor");

		final ViewTuple<MainView, MainViewModel> viewTuple = FluentViewLoader.javaView(MainView.class).load();

		final Parent root = viewTuple.getView();
		stage.setScene(new Scene(root));
		stage.show();
	}
}
