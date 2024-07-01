package view.administrador;

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
import managers.AdministradorManager;
import model.Administrador;
import view.FXMLControlador;

public class AdministradorControlador {
	
	@FXML
	private TextField campoNome;
	
	@FXML
	private ChoiceBox<String> campoFaixaEtaria;
	
	@FXML
	private ChoiceBox<String> campoSexo;
	
	@FXML
	private TextField campoSalario;
	
	@FXML
	private TextField campoCargo;
	
	@FXML
	private TextField campoId;

	private AdministradorManager administradorManager = new AdministradorManager();
	
	private DAO<Administrador> dao = new DAO<>(Administrador.class);
	
	public void adicionarAdministrador(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/administrador/adicionarAdministrador.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/administrador/adicionarAdministrador.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene adicionarAdministrador = new Scene(raiz, 350, 400);
		adicionarAdministrador.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Adicionar Administrador");
	    stage.setScene(adicionarAdministrador);
	    stage.show();

	}
	
	public void removerAdministrador(ActionEvent event) throws IOException {
		String arquivoCSS = getClass().getResource("/view/administrador/removerAdministrador.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/administrador/removerAdministrador.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene removerAdministrador = new Scene(raiz, 350, 400);
		removerAdministrador.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Remover Administrador");
	    stage.setScene(removerAdministrador);
	    stage.show();
	}
	
	public void listaDeAdministradores(ActionEvent event) throws IOException {		
		String arquivoCSS = getClass().getResource("/view/administrador/listaDeAdministradores.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/administrador/listaDeAdministradores.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene listaDeAdministradores = new Scene(raiz, 350, 400);
		listaDeAdministradores.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Lista De Administradores");
	    stage.setScene(listaDeAdministradores);
	    stage.show();
	}
	
	public void menuPrincipal(ActionEvent event) throws IOException {
		FXMLControlador controlador = new FXMLControlador();
		controlador.menuPrincipal(event);
	}
	
	public void voltarAdministrador(ActionEvent event) throws IOException {
		FXMLControlador controlador = new FXMLControlador();
		controlador.administradorManager(event);
	}
	
	@FXML
	public void salvarAdicionarAdministrador(ActionEvent event) throws IOException {
		
		String nome = campoNome.getText();
		String faixaEtaria = campoFaixaEtaria.getValue();
		String sexo = campoSexo.getValue();
		double salario = Double.parseDouble(campoSalario.getText());
		String cargo = campoCargo.getText();
		
		administradorManager.adicionarAdministrador(nome, faixaEtaria, sexo, salario, cargo);

		//TODO Adicionar pop-up Administrador adicionado!
		
		voltarAdministrador(event);
	}
	
	
	public void buscarAdministrador(ActionEvent event) throws IOException {
		
		Administrador administrador = dao.encontrar(campoId.getText());
		
		if(administrador == null) {
			administradorNaoEncontrado(event);
		} else {
	       	administradorEncontrado(event);
		}
	}
	
	public void administradorNaoEncontrado(ActionEvent event) throws IOException {		
		String arquivoCSS = getClass().getResource("/view/administrador/administradorNaoEncontrado.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/view/administrador/administradorNaoEncontrado.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene administradorNaoEncontrado = new Scene(raiz, 350, 400);
		administradorNaoEncontrado.getStylesheets().add(arquivoCSS);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Escola de Magia - Remover Administrador");
	    stage.setScene(administradorNaoEncontrado);
	    stage.show();
	}
	
	public void administradorEncontrado(ActionEvent event) throws IOException {		
		System.out.println("Administrador encontrado! ");
	} 
	
	public void botaoRemover(ActionEvent event) throws IOException {
		// TODO adicionar pop-up Professor removido
		
		System.out.println("Administrador removido");
		
		removerAdministrador(event);
	}
}
