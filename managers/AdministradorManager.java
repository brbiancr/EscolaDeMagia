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
	
	public void adicionarAdministrador() {
		System.out.print("Nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Idade: ");
		int idade = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Sexo: ");
		String sexo = entrada.nextLine();
		
		System.out.print("Salario: ");
		double salario = entrada.nextDouble();
		entrada.nextLine();
		
		System.out.print("Cargo: ");
		String cargo = entrada.nextLine();
		
		Administrador administrador= new Administrador(nome, idade, sexo, salario, cargo);
		
		dao.incluirTransacao(administrador);
		
		System.out.println("\nAdministrador adicionado com sucesso!");
		System.out.println("ID do administrador: " + administrador.getId() + "\n");
	}
	
	public void removerAdministrador() {
		
		List<Administrador> administradores = dao.obterTodos();
		
		if(administradores.isEmpty()) {
			System.out.println("Não há administradores cadastrados!");
		} else {
			System.out.print("ID do Administrador: ");
			String idAdministrador = entrada.nextLine();
			
			Administrador administrador = dao.encontrar(idAdministrador);
			
			if(administrador != null) {
				dao.remover(administrador);
				System.out.println("Administrador removido!");
			} else {
				System.out.println("Administrador não econtrado!");
			}
		}	
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
				case 1: adicionarAdministrador();
						break;
				
				case 2: removerAdministrador();
						break;
						
				case 3: listarAdministradores();
						break;
						
				case 4: sair = true;
						break;
						
				default: System.out.println("Opção invalida, digite uma opção valida!");
			}
		}
	}
}
