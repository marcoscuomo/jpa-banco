package br.com.mojumob.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.mojumob.financas.modelo.Categoria;
import br.com.mojumob.financas.modelo.Conta;
import br.com.mojumob.financas.modelo.Movimentacao;
import br.com.mojumob.financas.modelo.TipoMovimentacao;
import br.com.mojumob.financas.util.JPAUTIL;

public class TesteMovimentacaoComCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance()); //Hoje
		movimentacao1.setDescricao("Viagem a SP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.00"));
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance()); //Hoje
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.00"));
		movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUTIL().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
