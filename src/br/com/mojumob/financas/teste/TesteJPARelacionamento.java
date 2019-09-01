package br.com.mojumob.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.mojumob.financas.modelo.Conta;
import br.com.mojumob.financas.modelo.Movimentacao;
import br.com.mojumob.financas.modelo.TipoMovimentacao;
import br.com.mojumob.financas.util.JPAUTIL;
public class TesteJPARelacionamento {
	
public static void main(String[] args) {
		
	Conta conta = new Conta();
	conta.setBanco("Itau");
	conta.setAgencia("0102");
	conta.setNumero("3456");
	conta.setTitular("Carlos Souza");
	 
	
	Movimentacao movimentacao = new Movimentacao();
	movimentacao.setData(Calendar.getInstance());
	movimentacao.setDescricao("Churrascaria");
	movimentacao.setTipo(TipoMovimentacao.SAIDA);
	movimentacao.setValor(new BigDecimal("200.00"));
	
	movimentacao.setConta(conta);
	
	EntityManager em = new JPAUTIL().getEntityManager();
	em.getTransaction().begin();
	
	em.persist(conta);
	em.persist(movimentacao);
			
		
		
	em.getTransaction().commit();
	em.close();
		
}

}
