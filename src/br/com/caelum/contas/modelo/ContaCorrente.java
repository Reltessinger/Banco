package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel {

	public String getTipo() {
		return "Conta Corrente";
	}

	@Override
	public void sacar(double valor) {
		if (valor <= saldo) {
			this.saldo -= (valor + 0.10);
		} else {
			throw new SaldoInsuficienteException(valor);
		}

	}

	@Override
	public double getValorImposto() {
		return this.getSaldo() * 0.01;
	}
}
