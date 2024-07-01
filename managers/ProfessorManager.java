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
	
	public void adicionarProfessor(String nome, String faixaEtaria, String sexo, double salario) {
		
		Professor professor = new Professor(nome, faixaEtaria, sexo, salario);
		
		dao.incluirTransacao(professor);

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
	
}
