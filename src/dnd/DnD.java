package dnd;

import java.util.HashMap;
import java.util.InputMismatchException;

public class DnD {

	HashMap<String, Wizzard> wiz_HMap;
	HashMap<String, Warrior> war_HMap;
	Warrior g_war;
	static Wizzard g_wiz;
	String g_nom_perso, g_race, g_url;
	int g_life, g_attack;
	DnDScanner in_out;
	public static final String STR_RACE_CHOICE = "Quelle est la race de votre perso : Magicien ou Guerrier : ";
	public static final String STR_NAME_CHOICE = "Quel est le nom de votre perso : ";
	public static final String STR_LIFE_CHOICE = "Quelle est le niveau de vie(max 10) de votre perso : ";
	public static final String STR_ATTACK_CHOICE = "Quelle est le niveau d'attaque (max 10) de votre perso : ";
	public static final String STR_URL_CHOICE = "Quelle est l'url de l'image de votre perso : ";
	public static final String STR_PARAM_CHOICE = "Saisir le parametre à modifier (V)ie, (A)ttaque, (U)rl d'image, (E)quipement (defense ou attaque):";
	public static final String STR_SUCCESS = "Action réalisée avec succès !!";
	public static final String STR_INVALID = "Saisie invalide.";
	public static final String STR_INVALID_RACE = "Cette race n'existe pas (encore) !";
	public static final String STR_INVALID_NAME = "Ce nom est deja utilisé. Un autre ? ";

	/*
	 * ================================ CONSTRUCTEUR
	 * ======================================
	 */
	public DnD() {
		this.in_out = new DnDScanner();
		this.wiz_HMap = new HashMap<String, Wizzard>();
		this.war_HMap = new HashMap<String, Warrior>();
		this.g_nom_perso = "0";
		this.g_race = "0";
		this.g_url = "0";
		this.g_life = 0;
		this.g_attack = 0;
	}

	/*
	 * ================================ MENU ======================================
	 */
	public String Choix_utilisateur() {
		in_out.printStr("Souhaitez-vous :\n   (C)réer un perso\n   (L)ister les persos\n"
				+ "   (M)odifier les infos de votre perso,\n   (I)Obtenir des infos sur votre perso,\n" + "");
		String cmd = in_out.scan.nextLine();
		return cmd;
	}

	/*
	  ================================ CREA PERSO  ======================================
	 */
	public void crea_persoV2() {
		g_race = in_out.askString(STR_RACE_CHOICE);
		// -----> verif race existante ou non
		if (!g_race.equals("Magicien") && !g_race.equals("Guerrier")) {
			in_out.printStr(STR_INVALID_RACE);
			crea_persoV2();
			return;
		}
		if (g_race.equals("Guerrier")) {
			warCreaPerso();
		}
		if (g_race.equals("Magicien")) {
			wizCreaPerso();
		}
	}

	/*================================ MODIF PERSO ===================================*/
	public void modif_perso() {
		String param = in_out.askString(STR_PARAM_CHOICE);
		if (param.equals("V")) {
			modifVie();
		} else if (param.equals("A")) {
			modifAttack();
		} else if (param.equals("U")) {
			modifURL();
		} else if (param.equals("E")) {
			modifEquipement();
		} else {
			in_out.printStr(STR_INVALID);
		}
	}

	/* ================================ INFO PERSO======================================*/
	public void info_perso() {
		g_race = in_out.askString(STR_RACE_CHOICE);
		if (g_race.equals("Magicien")) {
			wizInfoPerso();
		} else if (g_race.equals("Guerrier")) {
			warInfoPerso();
		} else {
			in_out.printStr("Cette race n'existe pas (encore). Il faut recommencer !");
		}
	}

	/*================================ LISTER PERSO======================================*/
	public void lister_perso() {
		System.out.println(STR_RACE_CHOICE);
		String race = in_out.scan.nextLine();
		if (race.equals("Magicien")) {
			System.out.println(wiz_HMap);
		} else if (race.equals("Guerrier")) {
			System.out.println(war_HMap);
		}
		// TODO 30/04 : faire une boucle pour parcourir, et afficher les infos perso par
		// perso
	}

	/* ============================================================================
	  ==============================Fonctions "bas-niveau"=========================
	  ============================================================================
	 */
	public void warInfoPerso() {
		in_out.printStr(STR_NAME_CHOICE);
		g_nom_perso = in_out.scan.nextLine();
		g_war = war_HMap.get(g_nom_perso);
		if (!g_war.equals(null)) {
			in_out.printStr(war_HMap.get(g_nom_perso) + "Son equipement de défense est \"" + g_war.getBouclier()
					+ "\"\net son equipement d'attaque est \"" + g_war.getArme() + ".\n");
		} else {
			in_out.printStr("Ce perso n'existe pas encore !!");
		}
	}

	public void wizInfoPerso() {
		in_out.printStr(STR_NAME_CHOICE);
		g_nom_perso = in_out.scan.nextLine();
		g_wiz = wiz_HMap.get(g_nom_perso);
		if (!g_wiz.equals(null)) {
			in_out.printStr(wiz_HMap.get(g_nom_perso) + "Son equipement de défense est \"" + g_wiz.getPhiltre()
					+ "\"\net son equipement d'attaque est \"" + g_wiz.getSort() + ".\n");
		} else {
			in_out.printStr("Ce perso n'existe pas encore !!");
		}
	}

	private void modifVie() {
		g_race = in_out.askString(STR_RACE_CHOICE);
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		int new_value = in_out.askInt(STR_LIFE_CHOICE);
		if (g_race.equals("Magicien")) {
			g_wiz = wiz_HMap.get(g_nom_perso);
			g_wiz.setLife(new_value);
		}
		if (g_race.equals("Guerrier")) {
			g_war = war_HMap.get(g_nom_perso);
			g_war.setLife(new_value);
		}
	}

	private void modifAttack() {
		g_race = in_out.askString(STR_RACE_CHOICE);
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		int new_value = in_out.askInt(STR_ATTACK_CHOICE);
		if (g_race.equals("Magicien")) {
			g_wiz = wiz_HMap.get(g_nom_perso);
			g_wiz.setAttack(new_value);
		}
		if (g_race.equals("Guerrier")) {
			g_war = war_HMap.get(g_nom_perso);
			g_war.setAttack(new_value);
		}
		in_out.scan.nextLine();
	}

	private void modifURL() {
		g_race = in_out.askString(STR_RACE_CHOICE);
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		String new_value = in_out.askString(STR_URL_CHOICE);
		if (g_race.equals("Magicien")) {
			g_wiz = wiz_HMap.get(g_nom_perso);
			g_wiz.setURL(new_value);
		}
		if (g_race.equals("Guerrier")) {
			g_war = war_HMap.get(g_nom_perso);
			g_war.setURL(new_value);
		}
		in_out.scan.nextLine();
	}

	private void modifEquipement() {
		g_race = in_out.askString(STR_RACE_CHOICE);
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		// TODO 29/04 : chgmt equipement
		in_out.printStr("Cette foncionnalité n'existe pas pour l'instant");
	}

	// Creation Wizzard
	public void wizCreaPerso() {
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		g_wiz = wiz_HMap.get(g_nom_perso);
		if (g_wiz != null) {
			do {
				g_nom_perso = in_out.askString(STR_INVALID_NAME);
				g_wiz = wiz_HMap.get(g_nom_perso);
			} while (g_wiz != null);
		}
		while (true) {
			try {
				g_life = in_out.askInt(STR_LIFE_CHOICE);
				g_attack = in_out.askInt(STR_ATTACK_CHOICE);
				break;
			} catch (InputMismatchException error) {
				in_out.printStr(STR_INVALID);
				in_out.scan.nextLine();
			}
		}
		g_url = in_out.askString(STR_URL_CHOICE);
		if (g_race.equals("Magicien")) {
			try {
				g_wiz = new Wizzard(g_nom_perso, g_url, g_life, g_attack);
			} catch (IllegalArgumentException param_crea_invalides) {
				if (!g_nom_perso.equals("")) {
					g_wiz = new Wizzard(g_nom_perso);
				} else {
					g_wiz = new Wizzard();

				}
			}
			wiz_HMap.put(g_nom_perso, g_wiz);
		}
		in_out.printStr(STR_SUCCESS);
	}

	
	// Creation Warior
	public void warCreaPerso() {
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		g_war = war_HMap.get(g_nom_perso);
		if (g_war != null) {
			do {
				g_nom_perso = in_out.askString(STR_INVALID_NAME);
				g_war = war_HMap.get(g_nom_perso);
			} while (g_war != null);
		}
		while (true) {
			try {
				g_life = in_out.askInt(STR_LIFE_CHOICE);
				g_attack = in_out.askInt(STR_ATTACK_CHOICE);
				if(g_life < Warrior.niveauDeVieMin || g_life > Warrior.niveauDeVieMax || g_attack > Warrior.forceAttaqueMax || g_attack < Warrior.forceAttaqueMin) {
					in_out.printStr(STR_INVALID);
					continue;
				}
				break;
			} catch (InputMismatchException error) {
				in_out.printStr(STR_INVALID);
				in_out.scan.nextLine();
			}
		}
		g_url = in_out.askString(STR_URL_CHOICE);
		Perso war = new Warrior();
		try {

			war = new Warrior(g_nom_perso, g_url, g_life, g_attack);
		} 
		catch (Exception param_crea_invalides) {
			if (!g_nom_perso.equals("")) {
				war = new Warrior(g_nom_perso);
		}
		war_HMap.put(g_nom_perso, war);
		in_out.printStr(STR_SUCCESS);
	}
	}
}
		
		
	// public void crea_perso() {
	// g_race = in_out.askString(STR_RACE_CHOICE);
	// // -----> verif race existante ou non
	// if (!g_race.equals("Magicien") && !g_race.equals("Guerrier")) {
	// in_out.print(STR_INVALID_RACE);
	// crea_perso();
	// return;
	// }
	// g_nom_perso = in_out.askString(STR_NAME_CHOICE);
	// // -----> verif doublon de nom
	// if (g_race.equals("Magicien")) {
	// g_wiz = wiz_HMap.get(g_nom_perso);
	// if (g_wiz != null) {
	// do {
	// g_nom_perso = in_out.askString(STR_INVALID_NAME);
	// g_wiz = wiz_HMap.get(g_nom_perso);
	// } while (g_wiz != null);
	// }
	// }
	// if (g_race.equals("Warrior")) {
	// g_war = war_HMap.get(g_nom_perso);
	// if (g_war != null) {
	// do {
	// g_nom_perso = in_out.askString(STR_INVALID_NAME);
	// g_war = war_HMap.get(g_nom_perso);
	// } while (g_war != null);
	// }
	// }
	// // ----> verif saisie est un entier
	// while (true) {
	// try {
	// g_life = in_out.askInt(STR_LIFE_CHOICE);
	// g_attack = in_out.askInt(STR_ATTACK_CHOICE);
	// break;
	// } catch (InputMismatchException error) {
	// in_out.print(STR_INVALID);
	// in_out.scan.nextLine();
	// }
	// }
	// g_url = in_out.askString(STR_URL_CHOICE);
	// if (g_race.equals("Magicien")) {
	// try {
	// g_wiz = new Wizzard(g_nom_perso, g_url, g_life, g_attack);
	// } catch (IllegalArgumentException param_crea_invalides) {
	// if (!g_nom_perso.equals("")) {
	// g_wiz = new Wizzard(g_nom_perso);
	// } else {
	// g_wiz = new Wizzard();
	//
	// }
	// }
	// wiz_HMap.put(g_nom_perso, g_wiz);
	// } else if (g_race.equals("Guerrier")) {
	// try {
	// g_war = new Warrior(g_nom_perso, g_url, g_life, g_attack);
	// } catch (Exception param_crea_invalides) {
	// if (!g_nom_perso.equals("")) {
	// g_war = new Warrior(g_nom_perso);
	// } else {
	// g_war = new Warrior();
	// }
	// }
	// war_HMap.put(g_nom_perso, g_war);
	// }
	// in_out.print(STR_SUCCESS);
	// }

