package view.professor;

import java.io.IOException;
import java.net.URL;

import infra.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import managers.ProfessorManager;
import model.Professor;
import view.FXMLControlador;

public class ProfessorControlador {
	
	@FXML
	private TextField campoNome;
	
	@FXML
	private ChoiceBox<String> campoFaixaEtaria;
	
	@FXML
	private ChoiceBox<String> campoSexo;
	
	@FXML
	private TextField campoSalario;
	
	@FXML TextField campoID;
	
	private ProfessorManager professorManager = new ProfessorManager();
	
	private DAO<Professor> dao = new DAO<>(Professor.class);
	
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
		
		String nome = campoNome.getText();
		String faixaEtaria = campoFaixaEtaria.getValue();
		String sexo = campoSexo.getValue();
		double salario = Double.parseDouble(campoSalario.getText());
		
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + faixaEtaria);
		System.out.println("Sexo: " + sexo);
		System.out.println("Salario: " + salario);
		System.out.println("Professor adicionado!");
		
		professorManager.adicionarProfessor(nome, faixaEtaria, sexo, salario);
		
		//TODO Adicionar pop-up Aluno adicionado!
		
		voltarProfessor(event);
	}
	
	public void buscarProfessor(ActionEvent event) throws IOException {
		Professor professor = dao.encontrar(campoID.getText());
		
		if(professor == null) {
			professorNaoEncontrado(event);
		} else {
			professorEncontrado(event);
		}

	}
	
	public void professorNaoEncontrado(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/professor/professorNaoEncontrado.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/professor/professorNaoEncontrado.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene professorNaoEncontrado = new Scene(raiz, 350, 400);
		professorNaoEncontrado.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Remover Professor");
	    stage.setScene(professorNaoEncontrado);
	    stage.show();
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
