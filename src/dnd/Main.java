package dnd;

public class Main {
	public static void main(String[] args) {
		
		DnD donjon = new DnD();
		while(true) {
			String cmd = donjon.userChoice();
			
			if (cmd.equals("C")) {
				donjon.characterCreator();
			}
			else if (cmd.equals("L")) {
				donjon.characterList();
			}
			else if (cmd.equals("I")) {
				donjon.characterInfo();
			}
			else if (cmd.equals("M")) {
				donjon.characterModify();
			}
			else if (cmd.equals("J")) {
				donjon.playBoardGame();
			}
			
			else if (cmd.equals("Q")) {
				break;
			}
			else {
				System.out.println("Saisie invalide !");
			}
		}
	}
}
