package dnd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DnDScanner {

	Scanner scan = new Scanner(System.in);
	
	/* ================================ DDE INFO (String) ======================================*/
	public  String askString(String question) {
		try {
			System.out.println(question);
			return scan.nextLine();
		}
		catch (IllegalArgumentException e) {
			System.out.println("Saisie invalide");
			return askString(question);
		}
	}
	/* ================================ DDE INFO (Int) ======================================*/
	public int askInt(String question) {
		try {
			System.out.println(question);
			int saisie = scan.nextInt();
			scan.nextLine();
			return saisie;
		}
		catch (InputMismatchException e) {
			return askInt(question);
		}
	}

	/* ================================ DDE INFO (Int) ======================================*/
	public void printStr(String stce) {
		System.out.println(stce);
	}
}
