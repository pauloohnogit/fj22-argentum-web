package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao {

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {

		// Codigo para o exercicio 3.10 - 2
		if (data == null) {
			throw new IllegalArgumentException("Data não pode ser nula!");
		}

		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		// Codigo comentado pelo exercicio 3.10 - 1
		// return data;
		return (Calendar) this.data.clone();

		// Calendar copia = Calendar.getInstance();
		// copia.setTimeInMillis(this.data.getTimeInMillis());
		// return copia;

	}

	public double getVolume() {

		return this.preco * this.quantidade;

	}
}
