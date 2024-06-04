package managers;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Aluno;
import model.Disciplina;
import model.Professor;

public class DisciplinaManager {
	List<Disciplina> disciplinas;
	List<Professor> professores;
	List<Aluno> alunos;
	
	Scanner entrada = new Scanner(System.in);
	
	public DisciplinaManager(List<Disciplina> disciplinas, List<Professor> professores, List<Aluno> alunos) {
		this.disciplinas = disciplinas;
		this.professores =professores;
		this.alunos = alunos;
	}
	
	// Verifica se a lista de professores esta vazia
	// Caso contrário adiciona a disciplina a lista de disciplinas existentes
	public void adicionarDisciplina() {
		if(professores.isEmpty()) {
			System.out.println("Não há professores para ministrar a disciplina!");
		} else {
			System.out.print("Nome: ");
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
			disciplinas.add(disciplina);
			
			System.out.println("\nDisciplina criada com sucesso!\n");
			System.out.println("Código da disciplina" + disciplina.getCodigo() + "\n");
		}
		
	}
	
	// Remove a disciplina da lista de disciplinas a partir do codigo disciplina
	public void removerDisciplina() {
		if(disciplinas.isEmpty()) {
			System.out.println("Não há disciplinas cadastrados!");
		} else {
			System.out.print("Codigo da Disciplina: ");
			String codigo = entrada.nextLine();
			
			Boolean removido = false;
			
			for(Iterator<Disciplina> iterator = disciplinas.iterator(); iterator.hasNext();) {
				Disciplina disciplina = iterator.next();
				
				if(disciplina.getCodigo().equals(codigo)) {
					iterator.remove();
					removido = true;
					break;
				}
			}
			if(removido) {
				System.out.println("\nDisciplina removida com sucesso!\n");
			} else {
				System.out.println("\nDisciplina não encontrado\n");
			}
		}	
	}
	
	// Lista todas as disciplinas cadastradas
	public void listarDisciplinas() {
		if(disciplinas.isEmpty()) {
			System.out.println("Não há disciplinas cadastradas!");
		} else {
			for(Disciplina disciplina: disciplinas) {
				disciplina.imprimeDisciplina();
			}
		}
	}
	
	// Matricula o aluno em uma disciplin a partir do numero de matricula do aluno e do codigo da disciplina
	// Caso não existam alunos cadastrados e nem disciplinas cadastradas, volta-se para o menu das disciplinas
	
	public void gerenciarDisciplina() {
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
		if(alunos.isEmpty()) {		
			System.out.println("Não há alunos cadastrados!");
		} else{		
			System.out.print("- Numero de matricula: ");
			String matricula = entrada.nextLine();
			
			Boolean matriculado = false;
			
			for(Aluno aluno: alunos) {
				if(aluno.getId().equals(matricula)) {
					
					disciplina.getAlunosMatriculados().add(aluno);
					aluno.getDisciplinasMatriculadas().add(disciplina);
					
					matriculado = true;
				}
			}
			
			if(matriculado) {
				System.out.println("Aluno matriculado com sucesso!");
			} else {
				System.out.println("Matricula não encontrada! ");
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
		
		for(int i = 0; i < professores.size(); i++) {
			System.out.println("- " + i + " - " + professores.get(i).getNome() + "\n" + professores.get(i).getId());
		}
		
		int opcao = entrada.nextInt();
		entrada.nextLine();
		
		disciplina.setProfessorResponsavel(professores.get(opcao));
		
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
