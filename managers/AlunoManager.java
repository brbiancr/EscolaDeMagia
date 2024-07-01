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
	
	public void adicionarAluno(String nome, String faixaEtaria, String sexo, String reino) {
		
		Aluno aluno = new Aluno(nome, faixaEtaria, sexo, reino);
		
		dao.incluirTransacao(aluno);

		System.out.println("Matricula do aluno: " + aluno.getId() + "\n");
	}
	
	public void removerAluno(String matriculaAluno) {
		Aluno aluno = buscarAluno(matriculaAluno);
		
		if(aluno == null) {
			System.out.println("Aluno não encontrado");
		} else {
			dao.remover(aluno);
		}
	}
	
	public Aluno buscarAluno(String matriculaAluno) {
		Aluno aluno = dao.encontrar(matriculaAluno);
		
		return aluno;
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

		}
	}
}
