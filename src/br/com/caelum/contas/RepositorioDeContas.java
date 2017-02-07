package br.com.caelum.contas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;

public class RepositorioDeContas {
	public void salva(List<Conta> contas) {
		PrintStream stream;
		try {
			stream = new PrintStream("contas.txt");
			for (Conta conta : contas) {
				stream.println(conta.getTipo() + "," + conta.getNumero() + "," + conta.getAgencia() + ","
						+ conta.getTitular() + "," + conta.getSaldo());
			}
			stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Conta> carrega() {
		File file = new File("contas.txt");
		try {
			List<Conta> contas = new ArrayList<>();
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String linha = scan.nextLine();
				String[] valores = linha.split(",");
				String tipo = valores[0];
				int numero = Integer.parseInt(valores[1]);
				String agencia = valores[2];
				String titular = valores[3];
				double saldo = Double.parseDouble(valores[4]);
				Conta c;
				if (tipo.equals("Conta Corrente")) {
					c = new ContaCorrente();
				} else {
					c = new ContaPoupanca();
				}
				c.setNumero(numero);
				c.setAgencia(agencia);
				c.setTitular(titular);
				c.depositar(saldo);
				contas.add(c);
			}
			return contas;
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado !" );
		}
		return null;
	}
}
