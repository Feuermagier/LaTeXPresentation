package firemage.latexpres.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class MainViewLoader extends AnchorPane {

	public MainViewLoader() throws Exception {
		Node rootNode = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		getChildren().add(rootNode);
	}

}
