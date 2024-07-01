package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
	
	@Id
	private String id;
	
	private String nome;
	
	private String faixaEtaria;
	
	private String sexo;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String id, String nome, String faixaEtaria, String sexo) {
		this.id = id;
		this.nome = nome;
		this.faixaEtaria = faixaEtaria;
		this.sexo = sexo;
	}
	
	public void imprimeBasico() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Idade: " + this.faixaEtaria);
		System.out.println("Sexo: " + this.sexo);
	}
	
	// Usado para imprimir os dados relacionados a cada classe que herda Pessoa
	public abstract void imprimePessoa();
	
	
	// Gets and Sets
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
