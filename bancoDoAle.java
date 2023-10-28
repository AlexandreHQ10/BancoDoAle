package bancoDoAle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Banco {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double deposito, saque, total;
			String sair, opcao;

			deposito = 0;
			saque = 0;
			total = 0;
			sair = "s";

			do {
				System.out.println("~~~~~~ BANCO DO ALEXANDRE ~~~~~~");
				System.out.println("\nDigite a operação bancaria:");
				System.out.println("\nD - Depósito");
				System.out.println("\nS - Saque");
				System.out.println("\nE - Extrato");
				System.out.println("\nOpção: ");
				opcao = scanner.nextLine();

				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.println("~~~~~~ BANCO DO ALEXANDRE ~~~~~~");

				if (opcao.equals("d")) {
					System.out.print("\nDigite o valor para deposito (R$): ");
					deposito = scanner.nextDouble();
					scanner.nextLine();

					total = total + deposito;
					System.out.println("\nOperação realizada com sucesso!");
				} else if (opcao.equals("s")) {
					System.out.print("\nDigite o valor para saque (R$): ");
					saque = scanner.nextDouble();
					scanner.nextLine();

					total = total - saque;
					System.out.println("\nOperação realizada com sucesso!");
				} else if (opcao.equals("e")) {
					BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
					double roundedTotal = bd.doubleValue();
					System.out.println("\nSeu saldo total é de R$" + roundedTotal);
					System.out.println("\nOperação realizada com sucesso!");
				} else {
					System.out.println("\nOperação invalida!");
				}

				System.out.print("\nDeseja continuar? (s/n): ");
				sair = scanner.nextLine();

				System.out.print("\033[H\033[2J");
				System.out.flush();

			} while (!sair.equals("n"));
		}
		System.out.println("~~~~~~ BANCO DO ALEXANDRE ~~~~~~");
		System.out.println("\nObrigado e volte sempre!");
	}
}
