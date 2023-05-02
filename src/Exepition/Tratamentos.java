package Exepition;

import java.util.Scanner;

public class Tratamentos {

	static Scanner sc = new Scanner(System.in);

	public int tratamentoMenu() {
		int ok = 0;
		int inteiro = 0;

		do {

			try {
				inteiro = Integer.parseInt(sc.nextLine());
				ok = 0;

			} catch (Exception e) {
				System.err.println(
						"ESTE MENU NAO ACEITA TESTOS OU SIMBOLOS, APENAS NUMEROS.\nPOR FAVOR TENTE NOVAMENTE!");
				ok = 1;
			}

		} while (ok == 1);
		return inteiro;
	}

	public int tratamentoApagar() {
		int ok = 0;
		int inteiro = 0;

		do {

			try {
				inteiro = Integer.parseInt(sc.nextLine());
				ok = 0;

			} catch (Exception e) {
				System.err.println("ID DIGITADO INVALIDO OU INCORRETO.\nPOR FAVOR TENTE NOVAMENTE!");
				ok = 1;
			}

		} while (ok == 1);
		return inteiro;
	}

	public double lerDouble() {
		int ok = 0;
		double flutuante = 0;
		do {
			try {
				flutuante = Double.parseDouble(sc.nextLine());
				ok = 0;

			} catch (Exception e) {
				System.out.println("Eu esperava um Fracionado, digite novamente:");
				ok = 1;
			}
		} while (ok == 1);
		return flutuante;

	}

	public String tratamentoString() {
		return sc.nextLine();

	}
}