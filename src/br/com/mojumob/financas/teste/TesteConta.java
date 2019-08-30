package br.com.mojumob.financas.teste;

import javax.persistence.EntityManager;
import br.com.mojumob.financas.modelo.Conta;
import br.com.mojumob.financas.util.JPAUTIL;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setTitular("Marcos Souza");
		conta.setBanco("Itau");
		conta.setAgencia("2243");
		conta.setNumero("23243");
		
		EntityManager em = new JPAUTIL().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();

	}

}
