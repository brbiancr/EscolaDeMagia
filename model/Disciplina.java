package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import utilitarios.GerarIDs;

@Entity
@Table(name = "disciplinas")
public class Disciplina{
	
	@Id
	private String codigo;
	
	private String nome;
	
	@ManyToOne
	private Professor professorResponsavel;
		
	private Double cargaHoraria;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Aluno> alunosMatriculados;
	
	public Disciplina() {
		
	}
	
	public Disciplina(String nome, Professor professorResponsavel, Double cargaHoraria) {
		this.nome = nome;
		this.professorResponsavel = professorResponsavel;
		this.codigo = GerarIDs.gerarCodigo(nome);
		this.cargaHoraria = cargaHoraria;
		alunosMatriculados = new ArrayList<Aluno>();
	}
	
	// Imprime os dados formatados da disciplina
	public void imprimeDisciplina() {
		System.out.println("Disciplina: " + this.nome);
		System.out.println("Professor responsável: " + this.professorResponsavel.getNome());
		System.out.println("Codigo: " + this.codigo);
		System.out.println("Carga Horária: " + this.cargaHoraria + "\n");
	}
	
	// Imprime os alunos matriculados na disciplina
	public void imprimeAlunosMatriculados() {
		for(int i = 0; i > alunosMatriculados.size(); i++) {
			System.out.println(" - - " + i + " - -");
			alunosMatriculados.get(i).imprimePessoa();
		}
	}
	
	// Gets and Sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(Professor professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Aluno> getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}
}
