package view.aluno;

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
import managers.AlunoManager;
import view.FXMLControlador;

public class AlunoControlador {
	
	@FXML
	private TextField campoNome;
	
	@FXML
	private ChoiceBox<String> campoFaixaEtaria;
	
	@FXML
	private ChoiceBox<String> campoSexo;
	
	@FXML
	private ChoiceBox<String> campoReino;
	
	@FXML
	private TextField campoMatricula;
	
	private AlunoManager alunoManager = new AlunoManager();
	
	public void adicionarAluno(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/aluno/adicionarAluno.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/aluno/adicionarAluno.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene adicionarAluno = new Scene(raiz, 350, 400);
		adicionarAluno.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Adicionar Aluno");
	    stage.setScene(adicionarAluno);
	    stage.show();
	}
	
	public void removerAluno(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/aluno/removerAluno.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/aluno/removerAluno.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene removerAluno = new Scene(raiz, 350, 400);
		removerAluno.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Adicionar Aluno");
	    stage.setScene(removerAluno);
	    stage.show();

	}
	
	public void listaDeAlunos(ActionEvent event) throws IOException {		
		String arquivoCSS = getClass().getResource("/view/aluno/listaDeAlunos.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/aluno/listaDeAlunos.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene listaDeAlunos = new Scene(raiz, 350, 400);
		listaDeAlunos.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Lista De Alunos");
	    stage.setScene(listaDeAlunos);
	    stage.show();
	}
	
	public void gerenciarAluno(ActionEvent event) throws IOException {		
		String arquivoCSS = getClass().getResource("/view/aluno/gerenciarAluno.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/aluno/gerenciarAluno.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene gerenciarAluno = new Scene(raiz, 350, 400);
		gerenciarAluno.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Gerenciar Aluno");
	    stage.setScene(gerenciarAluno);
	    stage.show();
	}
	
	public void menuPrincipal(ActionEvent event) throws IOException {
		FXMLControlador controlador = new FXMLControlador();
		controlador.menuPrincipal(event);
	}
	
	public void voltarAluno(ActionEvent event) throws IOException {
		FXMLControlador controlador = new FXMLControlador();
		controlador.alunoManager(event);
	}
	
	@FXML
	public void salvarAdicionarAluno(ActionEvent event) throws IOException {
		String nome = campoNome.getText();
		String faixaEtaria = campoFaixaEtaria.getValue();
		String sexo = campoSexo.getValue();
		String reino = campoReino.getValue();
		
		System.out.println("Nome: " + nome);
		System.out.println("Faixa etaria: " + faixaEtaria);
		System.out.println("Sexo: " + sexo);
		System.out.println("Reino: " + reino);
		
		alunoManager.adicionarAluno(nome, faixaEtaria, sexo, reino);

		//TODO Adicionar pop-up Aluno adicionado!
		
		voltarAluno(event);
	}
	
	public void buscarAluno(ActionEvent event) throws IOException {
		Boolean encontrouAluno = true;
		
		if(encontrouAluno) {
			alunoEncontrado(event);
		} else {
			System.out.println("Mostrar aluno não encontrado");
		}
	}
	
	public void alunoEncontrado(ActionEvent event) throws IOException {		
		String arquivoCSS = getClass().getResource("/view/aluno/alunoEncontrado.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/aluno/alunoEncontrado.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene alunoEncontrado = new Scene(raiz, 350, 400);
		alunoEncontrado.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Remover Aluno");
	    stage.setScene(alunoEncontrado);
	    stage.show();
	}
	
	public void botaoRemover(ActionEvent event) throws IOException {
		// TODO adicionar pop-up Aluno removido
		
		System.out.println("Aluno removido");
		
		removerAluno(event);
	}
	
	public void buscarAlunoGerenciarAluno(ActionEvent event) throws IOException {
		Boolean encontrouAluno = true;
		
		if(encontrouAluno) {
			alunoEncontradoGerenciarAluno(event);
		} else {
			System.out.println("Mostrar aluno não encontrado");
		}
	}
	
	public void alunoEncontradoGerenciarAluno(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/aluno/alunoEncontradoGerenciarAluno.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/aluno/alunoEncontradoGerenciarAluno.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene alunoEncontradoGerenciarAluno = new Scene(raiz, 350, 400);
		alunoEncontradoGerenciarAluno.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Gerenciar Aluno");
	    stage.setScene(alunoEncontradoGerenciarAluno);
	    stage.show();
	}
	
	public void dadosDoAluno() {
		//TODO implementar
		
		System.out.println("Dados do aluno");
	}
	
	public void disciplinasMatriculadas() {
		//TODO implementar
		
		System.out.println("Disciplinas matriculadas");
	}
	
	public void desmatricularDisciplina() {
		// TODO implementar
		
		System.out.println("Desmatricular disciplina");
	}
}
