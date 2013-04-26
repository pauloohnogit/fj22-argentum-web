package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {

		// O codigo abaixo foi comentado pelo teste 3 do exercicio 3.1
		// double minimo = negociacoes.get(0).getPreco();
		// double maximo = negociacoes.get(0).getPreco();
		double volume = 0;

		double minimo = Double.MIN_VALUE;
		double maximo = Double.MAX_VALUE;

		for (Negociacao negociacao : negociacoes) {

			volume += negociacao.getVolume();

			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}

		}

		// O codigo abaixo foi comentado pelo teste 3 do exercicio 3.1
		// double abertura = negociacoes.get(0).getPreco();
		// double fechamento = negociacoes.get(negociacoes.size() -
		// 1).getPreco();

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco();

		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);

		// Opcionais: 2.12.3

		// return new CandleBuilder().comAbertura(abertura)
		// .comFechamento(fechamento).comMinimo(minimo).comMaximo(maximo)
		// .comVolume(volume).comData(data).geraCandle();

	}
}
