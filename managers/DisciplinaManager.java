package managers;

import java.util.List;
import java.util.Scanner;

import infra.DAO;
import model.Aluno;
import model.Disciplina;
import model.Professor;

public class DisciplinaManager {
	DAO<Disciplina> dao;
	
	Scanner entrada = new Scanner(System.in);
	
	public DisciplinaManager() {
		dao = new DAO<>(Disciplina.class);
	}
	
	// Verifica se a lista de professores esta vazia
	// Caso contrário adiciona a disciplina a lista de disciplinas existentes
	public void adicionarDisciplina() {
		DAO<Professor> daoP = new DAO<>(Professor.class);
		
		List<Professor> professores = daoP.obterTodos();
		
		if(professores.isEmpty()) {
			System.out.println("Não há professores para ministrar a disciplina!");
		} else {
			System.out.print("Nome da disciplina: ");
			String nome = entrada.nextLine();
			
			System.out.print("Professor responsavel\n");
			for(int i = 0; i < professores.size(); i++) {
				System.out.println("- - " + i  + " - -");
				professores.get(i).imprimePessoa();
			}
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			System.out.print("Carga Horária: ");
			Double cargaHoraria = entrada.nextDouble();
			entrada.nextLine();
			
			Disciplina disciplina = new Disciplina(nome, professores.get(opcao), cargaHoraria);
			dao.incluirTransacao(disciplina);
			
			System.out.println("\nDisciplina criada com sucesso!\n");
			System.out.println("Código da disciplina: " + disciplina.getCodigo() + "\n");
		}
		
	}
	
	// Remove a disciplina da lista de disciplinas a partir do codigo disciplina
	public void removerDisciplina() {
		List<Disciplina> disciplinas = dao.obterTodos();
		
		if(disciplinas.isEmpty()) {
			System.out.println("Não há disciplinas cadastradas!");
		} else {
			System.out.print("Código da disciplina: ");
			String codigo = entrada.nextLine();
			
			Disciplina disciplina = dao.encontrar(codigo);
			
			if(disciplina != null) {
				dao.remover(disciplina);
				System.out.println("Disciplina removida!");
			} else {
				System.out.println("Disciplina não econtrada!");
			}
		}		
	}
	
	// Lista todas as disciplinas cadastradas
	public void listarDisciplinas() {
		List<Disciplina> disciplinas = dao.obterTodos();
		
		if(disciplinas.isEmpty()) {
			System.out.println("Nenhuma disciplina encontrada! ");
		} else {
			for(Disciplina disciplina: disciplinas) {
				System.out.println("Codigo: " + disciplina.getCodigo()
									+ ", Nome: " + disciplina.getNome());
			}
		}
	}
	
	// Matricula o aluno em uma disciplin a partir do numero de matricula do aluno e do codigo da disciplina
	// Caso não existam alunos cadastrados e nem disciplinas cadastradas, volta-se para o menu das disciplinas
	
	public void gerenciarDisciplina() {
		List<Disciplina> disciplinas = dao.obterTodos();
		
		if(disciplinas.isEmpty()) {
			System.out.println("Não há disciplinas cadastradas! ");
		} else {
			System.out.println("\n- Selecione a disciplina -");
			for(int i = 0; i < disciplinas.size(); i++) {
				System.out.println("- " + i + " - " + disciplinas.get(i).getNome());
			}
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			menuGerenciarDisciplina(disciplinas.get(opcao));
		}		
	}
	
	// Matricula o aluno atravez do numero de matricula em uma disciplina já existente
	public void matricularAluno(Disciplina disciplina) {
		DAO<Aluno> daoA = new DAO<>(Aluno.class);
		
		List<Aluno> alunos = daoA.obterTodos();
		
		if(alunos.isEmpty()) {		
			System.out.println("Não há alunos cadastrados!");
		} else{		
			System.out.print("- Numero de matricula: ");
			String matricula = entrada.nextLine();
			
			Aluno aluno = daoA.encontrar(matricula);
			
			if(aluno == null) {
				System.out.println("Aluno nao encontrado!");
			} else {			
				disciplina.getAlunosMatriculados().add(aluno);
				aluno.getDisciplinasMatriculadas().add(disciplina);
				
				dao.atualizar(disciplina);
				daoA.atualizar(aluno);
				
				System.out.println(aluno.getId() + " matriculado com sucesso!");
			}
		}
	}
	
	public void desmatricularAluno(Disciplina disciplina) {
		if(disciplina.getAlunosMatriculados().isEmpty()) {
			System.out.println("Não há alunos matriculados!");
		} else {
			disciplina.imprimeAlunosMatriculados();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			disciplina.getAlunosMatriculados().remove(opcao);
			
			System.out.println("Aluno removida com sucesso! ");
		}
	}
	
	public void trocarProfessorResponsavel(Disciplina disciplina) {
		System.out.println("- Selecione o novo professor -");
		
		DAO<Professor> daoP = new DAO<>(Professor.class);
		
		List<Professor> professores = daoP.obterTodos();
		
		int i = 0;
		for(Professor professor: professores) {
			System.out.println(i + ": " + professor.getId() + " - " + professor.getNome());
			i++;
		}
		
		int opcao = entrada.nextInt();
		entrada.nextLine();
		
		disciplina.setProfessorResponsavel(professores.get(opcao));
		
		dao.atualizar(disciplina);
		
		System.out.println("Troca realizada com sucesso! ");
	}
	
	public void menuGerenciarDisciplina(Disciplina disciplina) {
		boolean sair = false;
		
		while(!sair) {
			MenuManager.exibirMenuGerenciarDisciplina();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
				case 1: matricularAluno(disciplina);
						break;
				
				case 2: desmatricularAluno(disciplina);
						break;
						
				case 3: trocarProfessorResponsavel(disciplina);
						break;
						
				case 4: disciplina.imprimeAlunosMatriculados();;
						break;
						
				case 5: disciplina.imprimeDisciplina();
						break;
				
				case 6: sair = true;
						break;
				
				default: System.out.println("Opção invalida, digite uma opção valida!");
			}
		}
	}
	
	public void menuDisciplina() {
		
		boolean sair = false;
		
		while(!sair) {
			MenuManager.exibirMenuDisciplina();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
				case 1: adicionarDisciplina();
						break;
				
				case 2: removerDisciplina();
						break;
						
				case 3: listarDisciplinas();
						break;
						
				case 4: gerenciarDisciplina();
						break;
						
				case 5: sair = true;
						break;
						
				default: System.out.println("Opção invalida, digite uma opção valida!");
			}
		}
	}
}
