package dad.calculadora.css.ui;

import java.io.IOException;
import java.util.*;

import dad.calculadora.css.Calculadora;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.GridPane;

public class CalcController {
	
	// model
	
	private Calculadora calculadora = new Calculadora();
	
	// view
	
	@FXML 
	private GridPane view;
	
	@FXML
	private TextField screenText;

	public CalcController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalcView.fxml"));
        loader.setController(this);
        loader.load();
	}
	
	@FXML
	private void initialize() {
		
		screenText.textProperty().bind(calculadora.screenProperty());
		
	}


	
	@FXML
	private void onOperationButtonHandle(ActionEvent e) {
		String texto = ((Button)e.getSource()).getText();
		if (texto.equals("CE")) {
			calculadora.cleanEverything();
		} else if (texto.equals("C")) {
			calculadora.clean();
		} else if (texto.equals("+/-")) {
			calculadora.negate();
		} else {
			calculadora.operate(texto.charAt(0));
		}
	}
	
	@FXML
	private void onCommaButtonHandle(ActionEvent e) {
		calculadora.insertComma();
	}
	
	@FXML
	private void onNumberButtonHandle(ActionEvent e) {
		String texto = ((Button)e.getSource()).getText();
		calculadora.insert(texto.charAt(0));
	}


	@FXML
	void onModernaAction(ActionEvent event) {
		Scene scene = view.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/moderna.css")).toExternalForm());
	}


	@FXML
	void onClasicaAction(ActionEvent event) {
		Scene scene = view.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/clasica.css")).toExternalForm());
	}


	public GridPane getView() {
		return view;
	}

}
