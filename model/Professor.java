package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import utilitarios.GerarIDs;

@Entity
@Table(name = "professores")
public class Professor extends Pessoa{
	
	private Double salario;
	
	@OneToMany(mappedBy = "professorResponsavel")
	private List<Disciplina> disciplinas;
	
	public Professor() {
		super();
	}
	
	public Professor(String nome, String faixaEtaria, String sexo, Double salario) {
		super(GerarIDs.gerarIdProfessor(), nome, faixaEtaria, sexo);
		this.salario = salario;
		disciplinas = new ArrayList<Disciplina>();
	}
	
	// Imprime os dados formatados do professor
	public void imprimePessoa() {
		super.imprimeBasico();
		System.out.println("ID Professor: " + getId());
		DecimalFormat formato = new DecimalFormat("#.##");
		String salarioFormatado = formato.format(this.salario);
		System.out.println("Salario: R$" + salarioFormatado + "\n");
	}
	
	// Gets and Sets
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}