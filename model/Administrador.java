package model;

import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.Table;

import utilitarios.GerarIDs;

@Entity
@Table(name = "administradores")
public class Administrador extends Pessoa{
	
	private Double salario;
	
	private String cargo;
	
	public Administrador() {
		super();
	}
	
	public Administrador(String nome, String faixaEtaria, String sexo, Double salario, String cargo) {
		super(GerarIDs.gerarIdAdministrador(), nome, faixaEtaria, sexo);
		this.salario = salario;
		this.cargo = cargo;
	}
	
	// Imprime os dados formatados do administrador
	public void imprimePessoa() {
		super.imprimeBasico();
		System.out.println("ID Administrador: " + getId());
		
		DecimalFormat formato = new DecimalFormat("#.##");
		String salarioFormatado = formato.format(this.salario);
		System.out.println("Salario: R$" + salarioFormatado + "\n");
		
		System.out.println("Cargo: " + this.cargo);
	}
	
	// Gets and Sets
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
