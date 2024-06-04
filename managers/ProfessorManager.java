package managers;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Professor;

public class ProfessorManager {
	
	List<Professor> professores;
	
	Scanner entrada = new Scanner(System.in);
	
	public ProfessorManager(List<Professor> professores) {
		this.professores = professores;
	}
	
	public void adicionarProfessor() {
		System.out.print("Nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Idade: ");
		int idade = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Sexo: ");
		String sexo = entrada.nextLine();
		
		System.out.print("Salario: ");
		Double salario = entrada.nextDouble();
		entrada.nextLine();
		
		Professor professor = new Professor(nome, idade, sexo, salario);
		professores.add(professor);
		
		System.out.println("\nProfessor adicionado com sucesso!\n");
		System.out.println("ID do professor: " + professor.getId() + "\n");
	}
	
	public void removerProfessor() {
		if(professores.isEmpty()) {
			System.out.println("Não há professores cadastrados!");
		} else {
			System.out.print("ID do Professor: ");
			String idProfessor = entrada.nextLine();
			
			Boolean removido = false;
			
			for(Iterator<Professor> iterator = professores.iterator(); iterator.hasNext();) {
				Professor professor = iterator.next();
				
				if(professor.getId().equals(idProfessor)) {
					iterator.remove();
					removido = true;
					break;
				}
			}
			if(removido) {
				System.out.println("\nProfessor removido com sucesso!\n");
			} else {
				System.out.println("\nProfessor não encontrado\n");
			}
		}	
	}
	
	public void listarProfessores() {
		if(professores.isEmpty()) {
			System.out.println("Não há professore cadastrados!");
		} else {
			for(Professor professor: professores) {
				professor.imprimePessoa();
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
