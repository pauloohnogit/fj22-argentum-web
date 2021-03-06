package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class CandlestickFactoryTest {

	// Exercicio 3.8 - 1,2
	@Test
	public void sequenciaSimplesDeNegociacoes() {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao3 = new Negociacao(42.3, 100, hoje);
		Negociacao negociacao4 = new Negociacao(45.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4);

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		// Inicio das assercoes - assert
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(45.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);

	}

	// Exercicio 3.8 - 3 - Testa apenas o volume 0 quando nao ha negociacoes
	@Test
	public void semNegociacoesGeraCandleComZeros() {

		Calendar hoje = Calendar.getInstance();

		List<Negociacao> negociacoes = Arrays.asList();

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);

	}

	// Exercicio 3.8 - 4 - Testa com uma negociacao apenas - deve dar tudo igual
	// no candle.
	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1);

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);

		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);

		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);

		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);

		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);

	}

	// Exercicio 3.10 - 3 - Testa todos os valores iguais a zero quando nao ha
	// negociacoes
	@Test
	public void semNegociacoesGeraCandleComTodosOsValoresZero() {

		Calendar hoje = Calendar.getInstance();

		List<Negociacao> negociacoes = Arrays.asList();

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);

	}

	// Exercicio 3.10 - 6 - Testa quando as negociacoes estao em ordem crescente
	// de valor
	@Test
	public void negociacoesEmOrdemCrescenteDeValor() {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao2 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao3 = new Negociacao(42.3, 100, hoje);
		Negociacao negociacao4 = new Negociacao(45.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4);

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		// Inicio das assercoes - assert
		Assert.assertEquals(39.8, candle.getAbertura(), 0.00001);
		Assert.assertEquals(45.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);

	}

	// Exercicio 3.10 - 6 - Testa quando as negociacoes estao em ordem
	// decrescente de valor
	@Test
	public void negociacoesEmOrdemDecrescenteDeValor() {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao4 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao3 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(42.3, 100, hoje);
		Negociacao negociacao1 = new Negociacao(45.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4);

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		// Inicio das assercoes - assert
		Assert.assertEquals(45.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(39.8, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);

	}

}
