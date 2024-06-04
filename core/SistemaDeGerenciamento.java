 package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import managers.AdministradorManager;
import managers.AlunoManager;
import managers.DisciplinaManager;
import managers.MenuManager;
import managers.ProfessorManager;
import model.Aluno;
import model.Disciplina;
import model.Professor;

public class SistemaDeGerenciamento {
	
	Scanner entrada = new Scanner(System.in);
	
	private static SistemaDeGerenciamento sistema = new SistemaDeGerenciamento(); 
	
	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<Disciplina> disciplinas;
	
	private AlunoManager areaDoAluno;
	private ProfessorManager areaDoProfessor;
	private AdministradorManager areaDoAdministrador;
	private DisciplinaManager areaDaDisciplina;
	
	public SistemaDeGerenciamento() {
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
		this.disciplinas = new ArrayList<Disciplina>();
		
		this.areaDoAluno = new AlunoManager(alunos);
		this.areaDoProfessor = new ProfessorManager(professores);
		this.areaDoAdministrador = new AdministradorManager();
		this.areaDaDisciplina = new DisciplinaManager(disciplinas, professores, alunos);
	}
	
	public static void main(String[] args) {
		sistema.menu();
	}
	
	public void menu() {
		
		boolean sair = false;
		
		while(!sair) {
			MenuManager.exibirMenuPrincipal();
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
				case 1: areaDoAluno.menuAluno();
						break;
						
				case 2: areaDoProfessor.menuProfessor();
						break;
						
				case 3: areaDoAdministrador.menuAdministrador();
						break;
						
				case 4: areaDaDisciplina.menuDisciplina();
						break;
						
				case 5: sair = true;
						break;
						
				default: System.out.println("Opção invalida, digite uma opção valida!\n");
			}
		}
	}
}
