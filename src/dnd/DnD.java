package dnd;

import java.util.HashMap;
import java.util.InputMismatchException;

public class DnD {

	HashMap<String, Perso> perso_HMap;
	HashMap<String, Wizzard> wiz_HMap;
	HashMap<String, Warrior> war_HMap;
	Warrior g_war;
	static Wizzard g_wiz;
	String g_nom_perso, g_race, g_url;
	int g_life, g_attack;
	DnDScanner in_out;
	public static final String MAGICIEN = "M";
	public static final String GUERRIER = "G";
	public static final String STR_RACE_CHOICE = "Quelle est la race de votre perso : (M)agicien ou (G)uerrier : ";
	public static final String STR_NAME_CHOICE = "Quel est le nom de votre perso : ";
	public static final String STR_LIFE_CHOICE = "Quelle est le niveau de vie(max 10) de votre perso : ";
	public static final String STR_ATTACK_CHOICE = "Quelle est le niveau d'attaque (max 10) de votre perso : ";
	public static final String STR_URL_CHOICE = "Quelle est l'url de l'image de votre perso : ";
	public static final String STR_PARAM_CHOICE = "Saisir le parametre à modifier (V)ie, (A)ttaque, (U)rl d'image, (E)quipement (defense ou attaque):";
	public static final String STR_SUCCESS = "Action réalisée avec succès !!";
	public static final String STR_INVALID = "Saisie invalide.";
	public static final String STR_INVALID_NAME = "Ce nom est deja utilisé. Un autre ? ";
	public static final String STR_INVALID_VALUE_WIZ = "\n(pour un magicien,le niveau de vie est compris entre 3 et 6, et d'attaque entre 8 et 15)\n";
	public static final String STR_INVALID_VALUE_WAR = "\n(pour un guerrier le niveau de vie et d'attaque sont compris entre 5 et 10)\n";
	public static final String STR_UNKNOWN_RACE = "Cette race n'existe pas (encore) !";
	public static final String STR_UNKNOWN_NAME = "Ce perso n'existe pas (encore) !";
	
	
	/* ================================ CONSTRUCTEUR====================================== */
	public DnD() {
		this.in_out = new DnDScanner();
		this.war_HMap = new HashMap<String, Warrior>();
		this.wiz_HMap = new HashMap<String, Wizzard>();
		this.perso_HMap = new HashMap<String, Perso>();

		this.g_nom_perso = "0";
		this.g_race = "0";
		this.g_url = "0";
		this.g_life = 0;
		this.g_attack = 0;
	}

	/*================================ MENU ====================================== */
	public String Choix_utilisateur() {
		in_out.printStr("\nSouhaitez-vous :\n   (C)réer un perso\n   (L)ister les persos\n"
				+ "   (M)odifier les infos de votre perso,\n   (I)Obtenir des infos sur votre perso,\n" + "");
		String cmd = in_out.scan.nextLine();
		return cmd;
	}

	/* ================================ CREA PERSO  ====================================== */
	public void crea_persoV2() {
		g_race = in_out.askString(STR_RACE_CHOICE);
		// -----> verif race existante ou non
		if (!g_race.equals(MAGICIEN) && !g_race.equals(GUERRIER)) {
			in_out.printStr(STR_UNKNOWN_RACE);
			crea_persoV2();
			return;
		}
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		Perso perso = perso_HMap.get(g_nom_perso);
		if (perso != null) {
			do {
				g_nom_perso = in_out.askString(STR_INVALID_NAME);
				perso = perso_HMap.get(g_nom_perso);
			} while (perso != null);
		}
		while (true) {
			try {
				g_life = in_out.askInt(STR_LIFE_CHOICE);
				g_attack = in_out.askInt(STR_ATTACK_CHOICE);
				if (g_race.equals(MAGICIEN) && g_life >= Wizzard.niveauDeVieMin && g_life <= Wizzard.niveauDeVieMax && g_attack <= Wizzard.forceAttaqueMax && g_attack >= Wizzard.forceAttaqueMin) {
					break;					
				}
				else if (g_race.equals(GUERRIER) && g_life >= Warrior.niveauDeVieMin && g_life <= Warrior.niveauDeVieMax && g_attack <= Warrior.forceAttaqueMax && g_attack >= Warrior.forceAttaqueMin) {
					break;
				}
				else {
					if (g_race.equals(MAGICIEN)){
							in_out.printStr(STR_INVALID_VALUE_WIZ);
					}
					else if (g_race.equals(GUERRIER)){
						in_out.printStr(STR_INVALID_VALUE_WAR);
					}
				}
			} 
			catch (InputMismatchException error) {
				in_out.printStr(STR_INVALID);
				in_out.scan.nextLine();
			}
		}
		g_url = in_out.askString(STR_URL_CHOICE);
		if (g_race.equals(MAGICIEN)) {
			perso = new Wizzard(g_nom_perso, g_url, g_life, g_attack);
		}
		if (g_race.equals(GUERRIER)) {
			perso = new Warrior(g_nom_perso, g_url, g_life, g_attack);
		}
		perso_HMap.put(g_nom_perso, perso);
		in_out.printStr(STR_SUCCESS);
	}


	/*================================ MODIF PERSO ===================================*/
	public void modif_perso() {
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		Perso perso = perso_HMap.get(g_nom_perso);
		if(!perso.equals(null)) {
			String param = in_out.askString(STR_PARAM_CHOICE);
			if (param.equals("V")) {
				modifVieV2(g_nom_perso);
			} else if (param.equals("A")) {
				modifAttackV2(g_nom_perso);
			} else if (param.equals("U")) {
				modifURLV2(g_nom_perso);
			} else if (param.equals("E")) {
				modifEquipement(g_nom_perso);
			} else {
				in_out.printStr(STR_INVALID);
			}
		}
	}

	/* ================================ INFO PERSO======================================*/
	public void info_perso() {						//------------> V2
		g_nom_perso = in_out.askString(STR_NAME_CHOICE);
		Perso perso = perso_HMap.get(g_nom_perso);
		if (perso != (null)) {
			in_out.printStr(perso.toStringFull());
			//ajouter un toString plus complet
		} 
		else {
			in_out.printStr(STR_UNKNOWN_NAME);
		}
	}

	/*================================ LISTER PERSO======================================*/
	public void lister_perso() {
		System.out.println(perso_HMap);
		// TODO 30/04 : faire une boucle pour parcourir, et afficher les infos perso par perso
	}

	/* ============================================================================
	  ==============================Fonctions "bas-niveau"=========================
	  ============================================================================
	 */

	private void modifVieV2(String name) {
		int new_value = in_out.askInt(STR_LIFE_CHOICE);
		Perso perso = perso_HMap.get(name);
		perso.setLife(new_value);
	}

	private void modifAttackV2(String name) {
		int new_value = in_out.askInt(STR_ATTACK_CHOICE);
		Perso perso = perso_HMap.get(name);
		perso.setAttack(new_value);
		in_out.scan.nextLine();
	}

	
	private void modifURLV2(String name) {
		String new_value = in_out.askString(STR_URL_CHOICE);
		Perso perso = perso_HMap.get(name);
		perso.setURL(new_value);
		in_out.scan.nextLine();
	}

	private void modifEquipement(String name) {
		Perso perso = perso_HMap.get(name);
		String cmd = in_out.askString("souhaitez-vous modifier l'équipement d'(A)ttaque ou de (D)éfense");
		if (cmd.equals("A")) {
			if (perso instanceof Wizzard) {
				String new_value = in_out.askString("Saisir le nom du sort");
				int int_new = in_out.askInt("Saisir la valeur d'attaque du sort");
				perso.SetEquipementAttack(new_value, int_new);
			}
			else if (perso instanceof Warrior) {
				String new_value = in_out.askString("Saisir le nom de l'arme");
				int int_new = in_out.askInt("Saisir la valeur d'attaque de l'arme");
				perso.SetEquipementAttack(new_value, int_new);
			}
		}
		else if (cmd.equals("D")) {
			if (perso instanceof Wizzard) {
				String new_value = in_out.askString("Saisir le nom du philtre");
				int int_new = in_out.askInt("Saisir la valeur d'attaque du philtre");
				perso.SetEquipementDefense(new_value, int_new);
			}
			else if (perso instanceof Warrior) {
				String new_value = in_out.askString("Saisir le nom du bouclier");
				int int_new = in_out.askInt("Saisir la valeur d'attaque du bouclier");
				perso.SetEquipementDefense(new_value, int_new);
			}
		}
		else {
			in_out.printStr(STR_INVALID);
		}
	}
}

