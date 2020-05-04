package dnd;

public class Main {
	public static void main(String[] args) {
	
		
		DnD donjon = new DnD();
		while(true) {
			String cmd = donjon.Choix_utilisateur();
			
			if (cmd.equals("C")) {
				donjon.crea_persoV2();
			}
			else if (cmd.equals("L")) {
				donjon.lister_perso();
			}
			else if (cmd.equals("I")) {
				donjon.info_perso();
			}
			else if (cmd.equals("M")) {
				donjon.modif_perso();
			}
	
		}
		 
	}

}
