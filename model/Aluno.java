package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import utilitarios.GerarIDs;

@Entity
@Table(name = "alunos")
public class Aluno extends Pessoa{
	
	private String reino;
	
	@ManyToMany(mappedBy = "alunosMatriculados", cascade = CascadeType.PERSIST)
	private List<Disciplina> disciplinasMatriculadas;
	//private Map<Disciplina, Double> nota;
	
	public Aluno() {
		super();
	}
	
	public Aluno(String nome, String faixaEtaria, String sexo, String reino) {
		super(GerarIDs.gerarMatricula(reino), nome, faixaEtaria, sexo);
		this.reino = reino;
		this.disciplinasMatriculadas = new ArrayList<Disciplina>();
	}
	
	// Imprime os dados formatados do aluno
	public void imprimePessoa() {
		super.imprimeBasico();
		System.out.println("Matricula: " + getId());
		System.out.println("Reino: " + this.reino + "\n");
	}
	
	// Imprime as disciplinas que o aluno esta matriculado
	public void imprimeDisciplinasMatriculadas() {
		for(int i = 0; i < disciplinasMatriculadas.size(); i++) {
			System.out.println(" - - " + i + " - -");
			disciplinasMatriculadas.get(i).imprimeDisciplina();
		}
	}
	
	// Gets and Sets
	public String getReino() {
		return reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}

	public List<Disciplina> getDisciplinasMatriculadas() {
		return disciplinasMatriculadas;
	}

	public void setDisciplinasMatriculadas(List<Disciplina> disciplinasMatriculadas) {
		this.disciplinasMatriculadas = disciplinasMatriculadas;
	}
}
