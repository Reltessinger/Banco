package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaArrays {

	public static void main(String[] args) {

		Conta[] contas = new Conta[10];
		double media = 0.0;

		for (int i = 0; i < contas.length; i++) {
			Conta conta = new ContaCorrente();
			conta.depositar(i * 100.0);
			contas[i] = conta;
			// System.out.println(conta.getSaldo());
		}

		for (Conta c : contas) {
			media += c.getSaldo();
		}
		media = media / contas.length;
		System.out.println(media);
	}
}
