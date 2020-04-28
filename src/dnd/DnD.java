package dnd;

import java.util.Scanner;

public class DnD {

	public static void main(String[] args) {
		while (true) {
			Scanner scan = new Scanner(System.in);
			//tableau (array list) pour stocker les persos

			System.out.println(	"Souhaitez-vous :\n   Lister les persos (List)\n   Modifier les infos de votre perso (Modif),\n   Obtenir des infos sur votre perso (Info),   Créer un perso (Crea) \n");
			String cmd = scan.nextLine();

			/* Creation de perso */
			if (cmd.equals("Crea")) {
				System.out.println("Veuillez choisir un perso : Magicien ou Guerrier : ");
				String perso = scan.nextLine();
				System.out.println("Veuillez choisir le nom de votre perso : ");
				String nom_perso = scan.nextLine();
				System.out.println("Veuillez choisir le niveau de vie(max 10) de votre perso : ");
				int life = scan.nextInt();
				System.out.println("Veuillez choisir le niveau d'attaque (max 10) de votre perso : ");
				int attack = scan.nextInt();
				System.out.println("Veuillez indiquer l'url de l'image de votre perso : ");
				String url = scan.nextLine();

				if (nom_perso != "") {
					if (life != 0 && attack != 0) {
						//construct complet
						switch (perso) {
						case "Magicien":
							new Wizzard(nom_perso, url, life, attack);
							break;
						case "Warrior":
							new Warrior(nom_perso, url, life, attack);
							break;
						}
					} else {
						//construct moit'
						switch (perso) {
						case "Magicien":
							new Wizzard(nom_perso);
							break;
						case "Warrior":
							new Warrior(nom_perso);
							break;
						}
					}
				} else {
					// construct defaut
					switch (perso) {
					case "Magicien":
						new Wizzard();
						break;
					case "Warrior":
						new Warrior();
						break;
					}
					// stocker les persos dans une liste (array list ?)

				}
			}
			/* Info de perso */
			// parcourir les persos dans la liste
			// lister les persos exitants
			// proposer un choix

		}
	}
	














