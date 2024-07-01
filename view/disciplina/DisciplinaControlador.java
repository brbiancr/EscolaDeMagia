package view.disciplina;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.FXMLControlador;


public class DisciplinaControlador {
	
	@FXML
	private TextField campoNomeDisciplina;
	
	@FXML
	private ChoiceBox<String> campoProfessorResponsavel;
	
	@FXML
	private TextField campoCargaHoraria;
	
	@FXML
	private TextField campoCodigo;
	
	
	
	public void adicionarDisciplina(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/disciplina/adicionarDisciplina.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/disciplina/adicionarDisciplina.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene adicionarDisciplina= new Scene(raiz, 350, 400);
		adicionarDisciplina.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Adicionar Disciplina");
	    stage.setScene(adicionarDisciplina);
	    stage.show();
	}
	
	public void gerenciarDisciplina() {
		System.out.println("Gerenciar Disciplina");
	}
	
	public void removerDisciplina(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/disciplina/removerDisciplina.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/disciplina/removerDisciplina.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene removerDisciplina= new Scene(raiz, 350, 400);
		removerDisciplina.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Remover Disciplina");
	    stage.setScene(removerDisciplina);
	    stage.show();
	}
	
	public void listaDeDisciplinas() {
		System.out.println("Lista De Disciplinas");
	}
	
	public void menuPrincipal(ActionEvent event) throws IOException {
		FXMLControlador controlador = new FXMLControlador();
		controlador.menuPrincipal(event);
	}
	
	public void voltarDisciplina(ActionEvent event) throws IOException {
		FXMLControlador controlador = new FXMLControlador();
		controlador.disciplinaManager(event);
	}
	
	@FXML
	public void salvarAdicionarDisciplina(ActionEvent event) throws IOException {
		System.out.println("Nome: " + campoNomeDisciplina.getText());
		System.out.println("Professor Responsavel: " + campoProfessorResponsavel.getValue());
		System.out.println("Carga Horaria: " + campoCargaHoraria.getText());
		System.out.println("Disciplina adicionada!");
		
		//TODO Adicionar pop-up Disciplina adicionada!
		
		voltarDisciplina(event);
	}
	
	public void buscarDisciplina() {
		System.out.println("Buscar disciplina");
	}
}
