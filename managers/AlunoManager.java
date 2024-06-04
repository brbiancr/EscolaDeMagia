package managers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Aluno;

public class AlunoManager {
	
	List<Aluno> alunos;
	List<String> reinos;
	 
	Scanner entrada = new Scanner(System.in);
	
	public AlunoManager(List<Aluno> alunos) {
		this.alunos = alunos;
		this.reinos = new ArrayList<String>(List.of("Andros", "Solaria", "Calisto", "Dolana", "Domino", "Linphea", "Melodia", "Terra", "Zenith"));
	}
	
	public void adicionarAluno() {
		System.out.print("Nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Idade: ");
		int idade = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Sexo: ");
		String sexo = entrada.nextLine();
		
		System.out.print("Selecionar reino: ");
		for(String reino: reinos) {
			System.out.println(reinos.indexOf(reino) + "- " + reino );
		}
		int opcao = entrada.nextInt();
		entrada.nextLine();
		
		Aluno aluno = new Aluno(nome, idade, sexo, reinos.get(opcao));
		alunos.add(aluno);
		
		System.out.println("\nAluno adicionado com sucesso!\n");
		System.out.println("Matricula do aluno" + aluno.getId() + "\n");
	}
	
	public void removerAluno() {
		
		if(alunos.isEmpty()) {
			System.out.println("Não há alunos matriculados!");
		} else {
			System.out.print("Matricula do aluno: ");
			String matricula = entrada.nextLine();
			
			Boolean removido = false;
			
			for(Iterator<Aluno> iterator = alunos.iterator(); iterator.hasNext();) {
				Aluno aluno = iterator.next();
				
				if(aluno.getId().equals(matricula)) {
					iterator.remove();
					removido = true;
					break;
				}
			}
			
			if(removido) {
				System.out.println("\nAluno removido com sucesso!\n");
			} else {
				System.out.println("\nAluno não encontrado\n");
			}
		}	
	}
	
	public void listarAlunos() {
		if(alunos.isEmpty()) {
			System.out.println("Não há alunos cadastrados!");
		} else {
			for(Aluno aluno: alunos) {
				aluno.imprimePessoa();
			}
		}
	}
	
	public void gerenciarAluno() {
		if(alunos.isEmpty()) {
			System.out.println("Não há alunos cadastrados! ");
		} else {
			
			System.out.println("\n- Selecione o aluno -");
			for(int i = 0; i < alunos.size(); i++) {
				System.out.println("- " + i + " - " + alunos.get(i).getNome() + " - Matricula: " + alunos.get(i).getId());
			}
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			menuGerenciarAluno(alunos.get(opcao));
		}
	}
	
	public void desmatricularDisciplina(Aluno aluno) {
		if(aluno.getDisciplinasMatriculadas().isEmpty()) {
			System.out.println("O aluno não esta matriculado em nenhuma disciplina!");
		} else {
			aluno.imprimeDisciplinasMatriculadas();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			aluno.getDisciplinasMatriculadas().remove(opcao);
			
			System.out.println("Aluno desmatriculado com sucesso! ");
		}
	}
	
	public void menuGerenciarAluno(Aluno aluno) {
		boolean sair = false;
		
		while(!sair) {
			MenuManager.exibirMenuGerenciarAluno();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
				case 1: aluno.getDisciplinasMatriculadas();
						break;
				
				case 2: desmatricularDisciplina(aluno);
						break;
						
				case 3: aluno.imprimePessoa();
						break;
						
				case 4: sair = true;
						break;
				
				default: System.out.println("Opção invalida, digite uma opção valida!");
			}
		}
	}
	
	public void menuAluno() {
		
		boolean sair = false;
		
		while(!sair) {
			MenuManager.exibirMenuAluno();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
				case 1: adicionarAluno();
						break;
				
				case 2: removerAluno();
						break;
						
				case 3: listarAlunos();
						break;
						
				case 4: gerenciarAluno();
						break;
						
				case 5: sair = true;
						break;
						
				default: System.out.println("Opção invalida, digite uma opção valida!");
			}
		}
	}
}
