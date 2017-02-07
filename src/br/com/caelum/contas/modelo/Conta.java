package br.com.caelum.contas.modelo;

/**
 * 
 * @author Rafael Reltessinger
 *
 */
public abstract class Conta implements Comparable<Conta> {

	private String titular;
	private int numero;
	protected double saldo;
	private String agencia;
	private String dataAbertura;

	/**
	 * Soma no valor do saldo
	 * 
	 * @param valor
	 */
	public void depositar(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		} else {
			this.saldo += valor;
		}
	}

	/**
	 * Subtrai o valor do Saldo da Conta
	 * 
	 * @param valor
	 *            Valor que será retirado da conta
	 * @return
	 * @throws Exception
	 */
	public void sacar(double valor) {
		if (valor <= saldo && valor > 0) {
			this.saldo -= valor;
		} else {
			throw new SaldoInsuficienteException(valor);
		}
	}

	public void transferir(double valor, Conta destino) {
		this.sacar(valor);
		destino.depositar(valor);
	}

	public double calculaRendimento() {
		double rendimento = this.saldo * 0.1;
		return rendimento;
	}

	public String recuperaDadosParaImpressao() {
		String dados = "Titular: " + this.titular + "\nNúmero: " + this.numero + "\nAgencia: " + this.agencia
				+ "\nData de Abertura: " + this.dataAbertura + "\nRendimento Mensal: R$ " + this.calculaRendimento()
				+ "\nSaldo: R$ " + this.saldo + "\n";
		return dados;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public int compareTo(Conta outraConta) {
		return this.titular.compareTo(outraConta.titular);
	}

	public abstract String getTipo();

	@Override
	public String toString() {
		return "[Titular: " + titular.toUpperCase() + ", Numero: " + numero + ", Agencia: " + agencia + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	

}