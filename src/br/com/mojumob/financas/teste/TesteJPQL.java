package br.com.mojumob.financas.teste;

import javax.persistence.EntityManager;
import br.com.mojumob.financas.util.JPAUTIL;

public class TesteJPQL {
	
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUTIL().getEntityManager();
		em.getTransaction().begin();
		
		
		
		em.getTransaction().commit();
		em.close();
	}

}
