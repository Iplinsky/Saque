package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados bancarios:");	
		System.out.println();
		System.out.print("Numero da conta: ");
		Integer numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		Double saldo = sc.nextDouble();
		System.out.print("Limite para saque: ");
		Double limiteDeSaque = sc.nextDouble();

		Account account = new Account(numero, titular, saldo, limiteDeSaque);
	
		try {
			System.out.println();
			System.out.print("Deseja realizar um saque (s/n)? ");
			char rls = sc.next().charAt(0);				
			while (rls == 's') {
				System.out.print("Digite o valor: ");
				Double valor = sc.nextDouble();				
				account.saque(valor);
				
				System.out.println("----------------------------------------------------------------");
				
				System.out.println("Saldo atualizado: " + String.format("%.2f", account.getSaldo()));
				System.out.println();
				System.out.print("Deseja fazer um novo saque (s/n)? ");
				rls = sc.next().charAt(0);
			}
			
			if (rls == 'n') {
				System.out.print("Deseja fazer um deposito (s/n)? ");
				char dp = sc.next().charAt(0);				
				if (dp == 's') {					
					System.out.print("Digite o valor para deposito: ");
					double valorDp = sc.nextDouble();
					account.deposito(valorDp);
					System.out.println("Saldo atualizado: " + String.format("%.2f", account.getSaldo()));
				} else {
					System.out.println("Dados bancarios");
					System.out.println(account);
				}
			}
		}
				
		catch(DomainException e) {
			
			System.out.println();
			System.out.println("Erro - " + e.getMessage());
		}
		
		catch(RuntimeException e) {
			
			System.out.println();
			System.out.println("Erro inesperado.");
		}
		
		sc.close();
	}

}

