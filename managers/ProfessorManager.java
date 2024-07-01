package managers;

import java.util.List;
import java.util.Scanner;

import infra.DAO;
import model.Professor;

public class ProfessorManager {
	DAO<Professor> dao;
	
	Scanner entrada = new Scanner(System.in);
	
	public ProfessorManager() {
		dao = new DAO<>(Professor.class);
	}
	
	public void adicionarProfessor() {
		System.out.print("Nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Faixa Etaria: ");
		String faixaEtaria = entrada.nextLine();
		
		System.out.print("Sexo: ");
		String sexo = entrada.nextLine();
		
		System.out.print("Salario: ");
		Double salario = entrada.nextDouble();
		entrada.nextLine();
		
		Professor professor = new Professor(nome, faixaEtaria, sexo, salario);
		dao.incluirTransacao(professor);
		
		System.out.println("\nProfessor adicionado com sucesso!\n");
		System.out.println("ID do professor: " + professor.getId() + "\n");
	}
	
	public void removerProfessor() {
		List<Professor> professores = dao.obterTodos();
		
		if(professores.isEmpty()) {
			System.out.println("Não há professores cadastrados!");
		} else {
			System.out.print("ID do professor: ");
			String idProfessor = entrada.nextLine();
			
			Professor professor = dao.encontrar(idProfessor);
			
			if(professor != null) {
				dao.remover(professor);
				System.out.println("Professor removido!");
			} else {
				System.out.println("Professor não econtrado!");
			}
		}	
	}
	
	public void listarProfessores() {
		List<Professor> professores = dao.obterTodos();
		
		if(professores.isEmpty()) {
			System.out.println("Nenhum professor encontrado");
		} else {
			for(Professor professor: professores) {
				System.out.println("Id: " + professor.getId()
									+ ", Nome: " + professor.getNome());
			}
		}
	}
	
	public void menuProfessor() {
		
		boolean sair = false;
		
		while(!sair) {
			MenuManager.exibirMenuProfessor();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
				case 1: adicionarProfessor();
						break;
				
				case 2: removerProfessor();
						break;
						
				case 3: listarProfessores();
						break;
						
				case 4: sair = true;
						break;
						
				default: System.out.println("Opção invalida, digite uma opção valida!");
			}
		}
	}
}
