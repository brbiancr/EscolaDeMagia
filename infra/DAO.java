package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

// Classe generica, pode ser usada para qualquer entidade(Adm, aluno, ...)
public class DAO<E> {
	
	//Ele é responsável por criar instâncias de EntityManager, que são usadas para interagir com o banco de dados.
	private static EntityManagerFactory emf;
	// Utilizado para gerenciar o ciclo de vida das entidades e realizar operações de persistência no banco de dados.
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("escola_de_magia");
		} catch(Exception e) {
			e.printStackTrace();
            throw new ExceptionInInitializerError(e);
		}
	}
	
	public DAO() { 
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> remover(E entidade){
		em.getTransaction().begin();
		em.remove(entidade); // Remove do banco, mas sera que remove da lista? Acho que não
		em.getTransaction().commit();
		return this;
	}
	
	public E encontrar(String id){
		return em.find(classe, id);		
	}
	
	public DAO<E> incluirTransacao(E entidade){
		return this.abrirTransacao().incluir(entidade).fecharTransacao(); 
	}
		
	public List<E> obterTodos(){
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		return query.getResultList();
	}
	
	// Gera uma consulta a partir de uma namedQuery
	public List<E> consultar(String nomeConsulta, Object... parametros){
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		// Percorre os parâmetros fornecidos, que são passados como pares nome-valor
		for(int i = 0; i < parametros.length; i += 2) {
			query.setParameter(parametros[i].toString(), parametros[i+1]);
		}
		
		// Executa a consulta e retorna os resultados como uma lista
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... parametros){
		List<E> lista = consultar(nomeConsulta, parametros);
		
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public void fechar(){
		em.close();
	}
}
