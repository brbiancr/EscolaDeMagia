package managers;

import java.util.List;
import java.util.Scanner;

import infra.DAO;
import model.Administrador;

public class AdministradorManager {
	DAO<Administrador> dao;
	
	Scanner entrada = new Scanner(System.in);
	
	public AdministradorManager() {
		dao = new DAO<>(Administrador.class);
	}
	
	public void adicionarAdministrador(String nome, String faixaEtaria, String sexo, double salario, String cargo) {

		Administrador administrador= new Administrador(nome, faixaEtaria, sexo, salario, cargo);
		
		dao.incluirTransacao(administrador);

		System.out.println("ID do administrador: " + administrador.getId() + "\n");
	}
	
	public void removerAdministrador(String idAdministrador) {
		
		Administrador administrador = buscarAdministrador(idAdministrador);
		
		if(administrador == null) {
			System.out.println("Administrador não encontrado");
		} else {
			dao.remover(administrador);
		}
			
	}
	
	public Administrador buscarAdministrador(String idAdministrador) {
		Administrador administrador = dao.encontrar(idAdministrador);
		
		return administrador;
	}
	
	public void listarAdministradores() {
		List<Administrador> administrador = dao.obterTodos();
		
		if(administrador.isEmpty()) {
			System.out.println("Nenhum administrador encontrado");
		} else {
			for(Administrador adm: administrador) {
				System.out.println("ID: " + adm.getId()
									+ ", Nome: " + adm.getNome());
			}
		}
	}
	
	public void menuAdministrador() {
		
		boolean sair = false;
		
		while(!sair) {
			MenuManager.exibirMenuAdministrador();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {				
				case 3: listarAdministradores();
						break;
						
				case 4: sair = true;
						break;
						
				default: System.out.println("Opção invalida, digite uma opção valida!");
			}
		}
	}
}