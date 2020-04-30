package dnd;

import java.util.Scanner;
import java.util.HashMap;


public class DnD {

	HashMap<String, Wizzard> wiz_HMap = new HashMap<String, Wizzard>();
	HashMap<String, Warrior> war_HMap = new HashMap<String, Warrior>();
	Warrior g_war; Wizzard g_wiz;
	String g_nom_perso, g_race, g_url;
	int g_life, g_attack;
	Scanner scan = new Scanner(System.in);


	/* ================================ CREA PERSO ======================================*/
	public void crea_perso() {
		System.out.println("Veuillez choisir un perso : Magicien ou Guerrier : ");
		g_race = scan.nextLine();
		if (!g_race.equals("Magicien") && !g_race.equals("Guerrier")) {						
			System.out.println("Cette race n'existe pas (encore). Il faut recommencer !");
			crea_perso();
			return;
		}
		
		System.out.println("Veuillez choisir le nom de votre perso : ");
		g_nom_perso = scan.nextLine();
		if(g_race.equals("Magicien")) {	
			g_wiz  = wiz_HMap.get(g_nom_perso);
			if (g_wiz != null) {
				do {
					System.out.println("Ce nom est deja utilisé. Un autre ? ");
					g_nom_perso = scan.nextLine();
					g_wiz  = wiz_HMap.get(g_nom_perso);
				}while (g_wiz != null);
			}
		}
		if(g_race.equals("Warrior")) {	
			g_war  = war_HMap.get(g_nom_perso);
			if (g_war != null) {
				do {
					System.out.println("Ce nom est deja utilisé. Un autre ? ");
					g_nom_perso = scan.nextLine();
					g_war  = war_HMap.get(g_nom_perso);
				}while (g_war != null);
			}
		}
		System.out.println("Veuillez choisir le niveau de vie(max 10) de votre perso : ");
		g_life = scan.nextInt();
		System.out.println("Veuillez choisir le niveau d'attaque (max 10) de votre perso : ");
		g_attack = scan.nextInt();
		scan.nextLine();
		System.out.println("Veuillez indiquer l'url de l'image de votre perso : ");
		g_url = scan.nextLine();
		if (g_race.equals("Magicien")) {
			try {
				g_wiz = new Wizzard(g_nom_perso, g_url, g_life, g_attack);
			}
			catch (Exception param_crea_invalides){
				if (!g_nom_perso.equals("")) {
					g_wiz = new Wizzard(g_nom_perso);
					System.out.println("Attention : certains parametres saisis sont invalides.(perso crée avec le nom seulement)");
				}
				else {
					g_wiz = new Wizzard();
					System.out.println("Attention : certains parametres saisis sont invalides. (le nom du perso sera 'Inconnu')");
				}
			}
			wiz_HMap.put(g_nom_perso, g_wiz);
		} 
		else if (g_race.equals("Guerrier")) {
			try {
				g_war = new Warrior(g_nom_perso, g_url, g_life, g_attack);
			}
			catch (Exception param_crea_invalides){
				if (!g_nom_perso.equals("")) {
					g_war = new Warrior(g_nom_perso);
					System.out.println("Attention : certains parametres saisis sont invalides (perso crée que avec le nom)");
				}
				else {
					g_war = new Warrior();
					System.out.println("Attention : le parametre saisi est invalide (le nom du perso sera 'Inconnu')");
				}
			}
			war_HMap.put(g_nom_perso, g_war);
		}
		System.out.println("Votre personnage a été créé avec succès !");
	}


	/* ================================ MODIF PERSO ======================================*/
	public void modif_perso() {
		System.out.println("Renseignez la race de votre perso, Magicien ou Guerrier : ");
		g_race = scan.nextLine();
		System.out.println("Renseignez le nom de votre perso : ");
		g_nom_perso = scan.nextLine();
		System.out.println("Quel parametre souhaitez-vous modifier (V)ie, (A)ttaque, (U)rl d'image, (E)quipement (defense ou Attaque):");
		String param = scan.nextLine();
		if (param.equals("V")) {
			System.out.println("Saisir la nouvelle valeur");
			int new_value = scan.nextInt();
			if (g_race.equals("Magicien")) {
				g_wiz = wiz_HMap.get(g_nom_perso);
				g_wiz.setLife(new_value);
			}
			if (g_race.equals("Guerrier")) {
				g_war = war_HMap.get(g_nom_perso);
				g_war.setLife(new_value);
			}
		}
		else if (param.equals("A")) {
			System.out.println("Saisir la nouvelle valeur");
			int new_value = scan.nextInt();
			if (g_race.equals("Magicien")) {
				g_wiz = wiz_HMap.get(g_nom_perso);
				g_wiz.setAttack(new_value);
			}
			if (g_race.equals("Guerrier")) {
				g_war = war_HMap.get(g_nom_perso);
				g_war.setAttack(new_value);
			}
		}
		else if (param.equals("U")) {
			System.out.println("Saisir la nouvelle valeur");
			String new_value = scan.nextLine();
			if (g_race.equals("Magicien")) {
				g_wiz = wiz_HMap.get(g_nom_perso);
				g_wiz.setURL(new_value);
			}
			if (g_race.equals("Guerrier")) {
				g_war = war_HMap.get(g_nom_perso);
				g_war.setURL(new_value);
			}
		}
		else if (param.equals("E")) {
			// TODO 29/04 : chgmt equipement
		}
		else {
			System.out.println("Saisie incorrecte !");
		}
	}

	/* ================================ INFO PERSO ======================================*/
	public void info_perso() {
		System.out.println("Renseignez la race de votre perso, Magicien ou Guerrier : ");
		g_race = scan.nextLine();
		System.out.println("Renseignez le nom de votre perso : ");
		g_nom_perso = scan.nextLine();
		if (g_race.equals("Magicien")) {
			//System.out.println(wiz_HMap.get(g_nom_perso));
			g_wiz = wiz_HMap.get(g_nom_perso);
			if (!g_wiz.equals(null)) {
				System.out.println("Son philtre est " + g_wiz.getPhiltre() + " et son sort est " + g_wiz.getSort());	
			}
			else {
				System.out.println("Ce perso n'existe pas encore !!");	
			}
		}
		if (g_race.equals("Guerrier")) {
			System.out.println(wiz_HMap.get(g_nom_perso));
			g_war = war_HMap.get(g_nom_perso);
		}
		//System.out.println("Race : ,\nNom : ,\n Point de vie : ,\n Point d'attaque : ,\n Arme : ,\n Defense :\n");
	}

	/* ================================ LISTER PERSO ======================================*/
	public void lister_perso() {
		System.out.println("Quels perso voulez-vous voir : Magicien ou Guerrier : ");
		String race = scan.nextLine();
		if (race.equals("Magicien")) {
			System.out.println(wiz_HMap);
		}
		else if (race.equals("Guerrier")) {
			System.out.println(war_HMap);
		}
	}

	/* ================================ MENU ======================================*/
	public String Choix_utilisateur() {
		System.out.println("Souhaitez-vous :\n   (C)réer un perso\n   (L)ister les persos\n"
				+ "   (M)odifier les infos de votre perso,\n   (I)Obtenir des infos sur votre perso,\n" + "");
		String cmd = scan.nextLine();
		return cmd;
	}
}

