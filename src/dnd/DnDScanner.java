package dnd;

import java.util.Scanner;

public class DnDScanner {

	Scanner scan = new Scanner(System.in);
	
	
	/* ================================ DDE INFO (String) ======================================*/
	public  String askString(String question) {
		System.out.println(question);
		return scan.nextLine();
	}
	/* ================================ DDE INFO (Int) ======================================*/
	public int askInt(String question) {
		System.out.println(question);
		int saisie = scan.nextInt();
		scan.nextLine();
		return saisie;
	}
	/* ================================ DDE INFO (Int) ======================================*/
	public void print(String stce) {
		System.out.println(stce);
	}
	
}
