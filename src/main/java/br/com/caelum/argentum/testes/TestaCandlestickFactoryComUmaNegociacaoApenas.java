package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryComUmaNegociacaoApenas {

	public static void main(String[] args) {

		// Obtem um calendar
		Calendar hoje = Calendar.getInstance();

		// Cria uma negociacao
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);

		// Cria a lista de negociacoes
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);

		// Obtem a fabrica de candlestick
		CandlestickFactory fabrica = new CandlestickFactory();

		// Solicita a fabrica a construcao do candlestick
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		// Exibe os valores do candlestick na console
		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());

	}
}
