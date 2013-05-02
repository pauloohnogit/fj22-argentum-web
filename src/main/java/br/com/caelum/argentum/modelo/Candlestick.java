package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candlestick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {

		// Codigo para o exercicio 3.10 - 4
		if (minimo > maximo) {
			throw new IllegalArgumentException(
					"Preço Minimo não pode exceder o preço máximo!");
		}

		// Codigo para o exercicio 3.10 - 5
		if (data == null) {
			throw new IllegalArgumentException("Data não pode ser nula!");

		}

		// Codigo para o exercicio 3.10 - 5
		if (abertura < 0) {
			throw new IllegalArgumentException(
					"Preço de abertura não pode ser negativo!");
		}

		// Codigo para o exercicio 3.10 - 5
		if (fechamento < 0) {
			throw new IllegalArgumentException(
					"Preço de fechamento não pode ser negativo!");
		}

		// Codigo para o exercicio 3.10 - 5
		if (minimo < 0) {
			throw new IllegalArgumentException(
					"Preço mínimo não pode ser negativo!");
		}

		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	// Opcionais: 2.9.14

	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	// Opcionais: 2.12.1

	@Override
	public String toString() {
		String descricao = "Abertura "
				+ this.abertura
				+ ", Fechamento "
				+ this.fechamento
				+ ", Mínima "
				+ this.minimo
				+ ", Máxima "
				+ this.maximo
				+ ", Volume "
				+ this.volume
				+ ", Data "
				+ new SimpleDateFormat("dd/MM/yyyy")
						.format(this.data.getTime());
		return descricao;
	}
}
