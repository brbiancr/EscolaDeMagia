package core;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SistemaDeGerenciamento extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		String arquivoCSS = getClass().getResource("/view/MenuPrincipal.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/MenuPrincipal.fxml");
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene menuPrincipal = new Scene(raiz, 350, 400);
		menuPrincipal.getStylesheets().add(arquivoCSS);
		
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Escola de Magia - Menu Principal");
		primaryStage.setScene(menuPrincipal);
		primaryStage.show();
		
	}
}
