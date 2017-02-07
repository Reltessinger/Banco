package br.com.caelum.contas.main;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaLista {
	public static void main(String[] args) {

		Random numero = new Random();
		List<Conta> contas = new LinkedList<>();

		for (int i = 0; i < 10; i++) {
			Conta c = new ContaCorrente();
			c.setNumero(numero.nextInt());
			c.setAgencia("123");
			c.setTitular("Conta " + i);
			contas.add(c);
		}

		for (Conta conta : contas) {
			System.out.println(conta);
		}
	}
}
