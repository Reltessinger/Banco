package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaTributavel {

	public static void main(String[] args) {

		ContaCorrente cc = new ContaCorrente();
		cc.depositar(100);
		System.out.println(cc.getValorImposto());

	}

}
