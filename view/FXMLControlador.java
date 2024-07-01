package view;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FXMLControlador {
	
	@FXML 
	private javafx.scene.control.Button sair;
	
	public void administradorManager(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/administrador/administradorManager.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/administrador/administradorManager.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene administradorManager = new Scene(raiz, 350, 400);
		administradorManager.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Administrador Manager");
	    stage.setScene(administradorManager);
	    stage.show();	
	}
	
	public void alunoManager(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/aluno/alunoManager.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/aluno/alunoManager.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene alunoManager = new Scene(raiz, 350, 400);
		alunoManager.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Aluno Manager");
	    stage.setScene(alunoManager);
	    stage.show();
	}
	
	public void disciplinaManager(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/disciplina/disciplinaManager.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/disciplina/disciplinaManager.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene disciplinaManager = new Scene(raiz, 350, 400);
		disciplinaManager.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Disciplina Manager");
	    stage.setScene(disciplinaManager);
	    stage.show();
	}
	
	public void professorManager(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/professor/professorManager.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/professor/professorManager.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene professorManager = new Scene(raiz, 350, 400);
		professorManager.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Professor Manager");
	    stage.setScene(professorManager);
	    stage.show();
	}
	
	@FXML
	public void sair() {
		Stage stage = (Stage) sair.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}

	public void menuPrincipal(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/menuPrincipal.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/menuPrincipal.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene menuPrincipal = new Scene(raiz, 350, 400);
		menuPrincipal.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Menu Principal");
	    stage.setScene(menuPrincipal);
	    stage.show();
	}

}
