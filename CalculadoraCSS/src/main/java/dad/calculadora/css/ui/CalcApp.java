package dad.calculadora.css.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.*;

public class CalcApp extends Application {

	private CalcController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new CalcController();
		Scene scene = new Scene(controller.getView(), 600, 450);
		scene.getStylesheets().clear();
		scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/moderna.css")).toExternalForm());
		primaryStage.setTitle("Calculadora");
		scene.getStylesheets().clear();
		primaryStage.getIcons().add(new Image("/images/calculator-32x32.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
