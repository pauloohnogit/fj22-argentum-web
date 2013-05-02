package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

	// Exercicio 3.10 - 1
	@Test
	public void dataDaNegociacaoEhImutavel() {

		Calendar hoje = Calendar.getInstance();

		hoje.set(Calendar.DAY_OF_MONTH, 5);

		Negociacao negociacao = new Negociacao(40.0, 100, hoje);

		negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);

		Assert.assertEquals(5, negociacao.getData().get(Calendar.DAY_OF_MONTH));

	}

	// Exercicio 3.10 - 2
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {

		new Negociacao(50.0, 100, null);

	}

}
