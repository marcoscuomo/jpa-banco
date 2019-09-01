package br.com.mojumob.financas.teste;

import javax.persistence.EntityManager;

import br.com.mojumob.financas.modelo.Conta;
import br.com.mojumob.financas.util.JPAUTIL;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUTIL().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1); 
		
		//Estado Managed
		//Estado em que os valores estão sincronizados com o banco.
		conta.setTitular("Well Souza");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		
	}

}
