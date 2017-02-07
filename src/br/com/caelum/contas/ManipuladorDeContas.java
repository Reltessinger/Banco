package br.com.caelum.contas;

import java.util.Collections;
import java.util.List;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {

	private Conta conta;

	public void criaConta(Evento evento) {

		String tipo = evento.getSelecionadoNoRadio("tipo");

		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else if (tipo.equals("Conta Poupança")) {
			this.conta = new ContaPoupanca();
		}

		this.conta.setTitular(evento.getString("titular"));
		this.conta.setAgencia(evento.getString("agencia"));
		this.conta.setNumero(evento.getInt("numero"));

	}

	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.depositar(valorDigitado);
	}

	public void saca(Evento evento) throws Exception {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.sacar(valorDigitado);
	}

	public void transfere(Evento evento) throws Exception {
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
		conta.transferir(evento.getDouble("valorTransferencia"), destino);
	}

	public void ordenaLista(Evento evento) {
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas);
	}

	public void salvaDados(Evento evento) {
		List<Conta> contas = evento.getLista("listaContas");
		RepositorioDeContas repositorio = new RepositorioDeContas();
		repositorio.salva(contas);
	}

	public List<Conta> carregaDados() {
		RepositorioDeContas repositorio = new RepositorioDeContas();
		return repositorio.carrega();
	}
}