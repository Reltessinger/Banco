package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Banco;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaBanco {

	public static void main(String[] args) {
		Banco banco = new Banco("CaelumBank", 999);

		for (int i = 0; i < 5; i++) {
			ContaCorrente conta = new ContaCorrente();
			conta.setTitular("Batman " + i);
			conta.setAgencia("1000");
			conta.setNumero(i);
			conta.depositar(i * 100);
			banco.adiciona(conta);
		}
		ContaCorrente c1 = new ContaCorrente();
		c1.setTitular("Batman 0");
		c1.setAgencia("1000");
		c1.setNumero(4);
		c1.depositar(1 * 100);

		banco.mostraContas();
		System.out.println(banco.contem(c1));
	}

}
