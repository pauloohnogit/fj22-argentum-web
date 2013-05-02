package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		// Candlestick(abertura, fechamento, minimo, maximo, volume, data)
		new Candlestick(10.0, 20.0, 30.0, 15.0, 1000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComDataNula() {
		new Candlestick(10, 20, 5, 30, 1000, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComPrecoAberturaNegativo() {
		new Candlestick(-10, 20, 10, 20, 1000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComPrecoFechamentoNegativo() {
		new Candlestick(10, -20, -20, 10, 1000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComPrecoMinimoNegativo() {
		new Candlestick(10, 20, -20, 10, 1000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandlestickComPrecoMaximoNegativo() {
		new Candlestick(10, 20, -20, -10, 1000, Calendar.getInstance());
	}

}
