package view.professor;

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

public class ProfessorControlador {
	
	@FXML
	private TextField campoNome;
	
	@FXML
	private TextField campoIdade;
	
	@FXML
	private ChoiceBox<String> campoSexo;
	
	@FXML
	private TextField campoSalario;
	
	@FXML TextField campoID;
	
	public void adicionarProfessor(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/professor/adicionarProfessor.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/professor/adicionarProfessor.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene adicionarProfessor= new Scene(raiz, 350, 400);
		adicionarProfessor.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Adicionar Professor");
	    stage.setScene(adicionarProfessor);
	    stage.show();
	}
	
	public void removerProfessor(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/professor/removerProfessor.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/professor/removerProfessor.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene removerProfessor= new Scene(raiz, 350, 400);
		removerProfessor.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Remover Professor");
	    stage.setScene(removerProfessor);
	    stage.show();
  
	}
	
	public void listaDeProfessores() {
		System.out.println("Lista De Professores");
	}
	
	public void menuPrincipal(ActionEvent event) throws IOException {
		FXMLControlador controlador = new FXMLControlador();
		controlador.menuPrincipal(event);
	}
	
	public void voltarProfessor(ActionEvent event) throws IOException {
		FXMLControlador controlador = new FXMLControlador();
		controlador.professorManager(event);
	}
	
	@FXML
	public void salvarAdicionarProfessor(ActionEvent event) throws IOException {
		System.out.println("Nome: " + campoNome.getText());
		System.out.println("Idade: " + campoIdade.getText());
		System.out.println("Sexo: " + campoSexo.getValue());
		System.out.println("Salario: " + campoSalario.getText());
		System.out.println("Professor adicionado!");
		
		//TODO Adicionar pop-up Aluno adicionado!
		
		voltarProfessor(event);
	}
	
	public void buscarProfessor(ActionEvent event) throws IOException {
		Boolean encontrouProfessor = true;
		
		if(encontrouProfessor) {
			professorEncontrado(event);
		} else {
			System.out.println("Mostrar prof não encontrado");
		}

	}
	
	public void professorEncontrado(ActionEvent event) throws IOException {		
		String arquivoCSS = getClass().getResource("/view/professor/professorEncontrado.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/professor/professorEncontrado.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene professorEncontrado = new Scene(raiz, 350, 400);
		professorEncontrado.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Remover Professor");
	    stage.setScene(professorEncontrado);
	    stage.show();
	}
	
	public void botaoRemover(ActionEvent event) throws IOException {
		// TODO adicionar pop-up Professor removido
		
		System.out.println("Professor removido");
		
		removerProfessor(event);
	}
}
