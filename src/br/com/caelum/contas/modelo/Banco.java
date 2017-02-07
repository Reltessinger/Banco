package br.com.caelum.contas.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private int numero;
	private List<Conta> contas;

	public Banco(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
		this.contas = new ArrayList<>();
	}

	public void adiciona(Conta c) {
		for (int i = 0; i < this.contas.size(); i++) {
			if (this.contas == null) {
				this.contas.add(c);
				return;
			}
		}
	}

	public void mostraContas() {
		for (Conta conta : contas) {
			System.out.println(conta);
		}
	}

	public boolean contem(Conta conta) {

		for (Conta c : contas) {
			if (c.equals(conta)) {
				return true;
			}
		}
		return false;
	}

	public Conta pega(int x) {
		return this.contas.get(x);
	}

	public int pegaQuantidadeDeContas() {
		return this.contas.size();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
