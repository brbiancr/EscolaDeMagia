package managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import infra.DAO;
import model.Aluno;
import model.Disciplina;

public class AlunoManager {
	DAO<Aluno> dao;

	List<String> reinos;
	 
	Scanner entrada = new Scanner(System.in);
	
	public AlunoManager() {
		dao = new DAO<>(Aluno.class);
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
		
		System.out.println("Selecionar reino: ");
		for(String reino: reinos) {
			System.out.println(reinos.indexOf(reino) + "- " + reino );
		}
		int opcao = entrada.nextInt();
		entrada.nextLine();
		
		Aluno aluno = new Aluno(nome, idade, sexo, reinos.get(opcao));
		dao.incluirTransacao(aluno);
		
		System.out.println("\nAluno adicionado com sucesso!\n");
		System.out.println("Matricula do aluno: " + aluno.getId() + "\n");
	}
	
	public void removerAluno() {
		List<Aluno> alunos = dao.obterTodos();
		
		if(alunos.isEmpty()) {
			System.out.println("Não há alunos matriculados!");
		} else {
			System.out.print("Matricula do aluno: ");
			String matricula = entrada.nextLine();
			
			Aluno aluno = dao.encontrar(matricula);
			
			if(aluno != null) {
				dao.remover(aluno);
				System.out.println("Aluno removido!");
			} else {
				System.out.println("Aluno não econtrado!");
			}
		}	
	}
	
	public void listarAlunos() {
		List<Aluno> alunos = dao.obterTodos();
		
		if(alunos.isEmpty()) {
			System.out.println("Nenhum aluno encontrado");
		} else {
			for(Aluno aluno: alunos) {
				System.out.println("Matricula: " + aluno.getId()
									+ ", Nome: " + aluno.getNome());
			}
		}
	}
	
	
	public void listarDisciplinasMatriculadas(Aluno aluno) {
		if(aluno.getDisciplinasMatriculadas().isEmpty()) {
			System.out.println("O aluno não esta matriculado em nenhuma disciplina!");
		} else {
			for(Disciplina disciplina: aluno.getDisciplinasMatriculadas()) {
				System.out.println(disciplina.getCodigo() + " - " + disciplina.getNome());
			}
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
	
	public void gerenciarAluno() {
		List<Aluno> alunos = dao.obterTodos();
		
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
	
	public void menuGerenciarAluno(Aluno aluno) {
		boolean sair = false;
		
		while(!sair) {
			MenuManager.exibirMenuGerenciarAluno();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
				case 1: listarDisciplinasMatriculadas(aluno);
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
