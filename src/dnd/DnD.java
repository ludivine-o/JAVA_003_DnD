package dnd;

import java.util.HashMap;

import boardgame.BoardBox;
import boardgame.BonusBoxPotion;
import boardgame.BonusBoxTreasure;
import boardgame.GameBoard;
import boardgame.MalusBoxGob;
import boardgame.MalusBoxOrcs;
import characters.Character;
import characters.Warrior;
import characters.Wizzard;

/**
 * 
 * @author ludivineo
 *<b> DnD est la classe 'coeur de jeu' </b>
 *elle a : 
 *	un membre DnD Scanner,
 *	un hashmap pour stocker les données
 *elle permet de :
 *	Créer un perso,
 *	Modifier un perso,
 *	Afficher les infos d'un perso,
 *	Lister les perso,
 */


public class DnD {

	HashMap<String, Character> character_HMap;
	//	HashMap<String, Wizzard> wiz_HMap;
	//	HashMap<String, Warrior> war_HMap;
	Warrior g_war;
	static Wizzard g_wiz;
	String g_character_name, g_race, g_url;
	int g_life, g_attack;
	DnDScanner in_out;
	GameBoard board;
	Character activePlayer;

	public static final String WIZZARD = "M";
	public static final String WARIOR = "G";
	public static final String STR_RACE_CHOICE = "Quelle est la race de votre perso : (M)agicien ou (G)uerrier : ";
	public static final String STR_NAME_CHOICE = "Quel est le nom de votre perso : ";
	public static final String STR_LIFE_CHOICE = "Quelle est le niveau de vie(max 10) de votre perso : ";
	public static final String STR_ATTACK_CHOICE = "Quelle est le niveau d'attaque (max 10) de votre perso : ";
	public static final String STR_URL_CHOICE = "Quelle est l'url de l'image de votre perso : ";
	public static final String STR_PARAM_CHOICE = "Saisir le parametre à modifier (U)rl d'image, (E)quipement (defense ou attaque):";
	public static final String STR_SUCCESS = "Action réalisée avec succès !!";
	public static final String STR_INVALID = "Saisie invalide.";
	public static final String STR_INVALID_NAME = "Ce nom est deja utilisé. Un autre ? ";
	public static final String STR_INVALID_VALUE_WIZ = "\n(pour un magicien,le niveau de vie est compris entre 3 et 6, et d'attaque entre 8 et 15)\n";
	public static final String STR_INVALID_VALUE_WAR = "\n(pour un guerrier le niveau de vie et d'attaque sont compris entre 5 et 10)\n";
	public static final String STR_UNKNOWN_RACE = "Cette race n'existe pas (encore) !";
	public static final String STR_UNKNOWN_NAME = "Ce perso n'existe pas (encore) !";
	public static final int LIFEMAX = 5;
	public static final int LIFEMIN = 10;
	public static final int ATTACKMIN = 5;
	public static final int ATTACKMAX = 10;




	/* ================================ CONSTRUCTEUR====================================== */
	public DnD() {
		this.in_out = new DnDScanner();
		this.board = new GameBoard();
		this.character_HMap = new HashMap<String, Character>();

		this.g_character_name = "0";
		this.g_race = "0";
		this.g_url = "0";
		this.g_life = 0;
		this.g_attack = 0;
	}

	/*================================ MENU ====================================== */
	public String userChoice() {
		in_out.printStr("\nSouhaitez-vous :\n   (C)réer un perso,\n   (L)ister les persos,\n"
				+ "   (M)odifier les infos de votre perso,\n   (I)Obtenir des infos sur votre perso,\n"
				+ "   (J)ouer sur le plateau,\n   (Q)uitter");
		String cmd = in_out.scan.nextLine();
		return cmd;
	}

	/* ================================ CREA PERSO  ====================================== */
	public void characterCreator() {
		g_race = in_out.askString(STR_RACE_CHOICE);
		//TODO 05/05 : faire une liste avec les races possibles, verif si saisie est existante.
		if (!g_race.equals(WIZZARD) && !g_race.equals(WARIOR)) {
			in_out.printStr(STR_UNKNOWN_RACE);
			characterCreator();
			return;
		}
		// /!\ Ici les valeurs min et max sont communes au deux types de perso !!!
		String name = nameChoice();
		g_url = in_out.askString(STR_URL_CHOICE);
		if (g_race.equals(WIZZARD)) {
			if (g_character_name.isEmpty() || g_url.isEmpty()) {
				character_HMap.put(name,new Wizzard());
			}
			else {
				character_HMap.put(name,new Wizzard(g_character_name, g_url));
			}
		}

		
		else if (g_race.equals(WARIOR)) {
			if (g_character_name.isEmpty() || g_url.isEmpty()) {
				character_HMap.put(name,new Warrior());
			}
			else {
				character_HMap.put(name, new Warrior(g_character_name, g_url));
			}
		}
		in_out.printStr(STR_SUCCESS);
	}

	/*================================ MODIF PERSO ===================================*/
	public void characterModify() {
		g_character_name = in_out.askString(STR_NAME_CHOICE);
		Character perso = character_HMap.get(g_character_name);
		if(!perso.equals(null)) {
			String param = in_out.askString(STR_PARAM_CHOICE);
			if (param.equals("U")) {
				urlModif(g_character_name);
			} else if (param.equals("E")) {
				equipmentModif(g_character_name);
			} else {
				in_out.printStr(STR_INVALID);
			}
		}
	}

	/* ================================ INFO PERSO======================================*/
	public void characterInfo() {						//------------> V2
		g_character_name = in_out.askString(STR_NAME_CHOICE);
		Character perso = character_HMap.get(g_character_name);
		if (perso != (null)) {
			in_out.printStr(perso.toStringFull());
		} 
		else {
			in_out.printStr(STR_UNKNOWN_NAME);
		}
	}

	/*================================ LISTER PERSO======================================*/
	public void characterList() {
		if (character_HMap.isEmpty()) {
			in_out.printStr("La liste des persos est vide ! Il faut en créer un !");
		}
		else {
			System.out.println(character_HMap);
		}

		// TODO 30/04 : faire une boucle pour parcourir, et afficher les infos perso par perso
	}

	/*================================ JOUER PLATEAU JEU ======================================*/
	public void playBoardGame() {
		Character activePlayer = null;
		//String var;
		int position = 0;
		BoardBox activeBox;
		in_out.printStr("Il faut choisir un joueur");
		if (character_HMap.isEmpty()) {
			in_out.printStr("La liste des persos est vide ! Il faut en créer un !");
		}
		else {
			System.out.println(character_HMap);
			g_character_name = in_out.askString(STR_NAME_CHOICE);
			activePlayer = character_HMap.get(g_character_name);
			if (activePlayer == (null)) {
				in_out.printStr(STR_UNKNOWN_NAME);
			}
			else  {		
				while (activePlayer != null && position < board.BOARDSIZE) {
					String cmd = in_out.askString("Pour avancer d'une case, appuyer sur 'A'");
					if (cmd.equals("A")) {
						activeBox = board.board.get(position);
						in_out.printStr(activeBox.toString());
						position ++;
						if (activeBox instanceof MalusBoxOrcs || activeBox instanceof MalusBoxGob) {
							activePlayer = board.applyMalusBoxEvent(activeBox, activePlayer);
						}
						else if (activeBox instanceof BonusBoxPotion || activeBox instanceof BonusBoxTreasure) {
							activePlayer = board.applyBonusBoxEvent(activeBox, activePlayer);
						}
						else {
							in_out.printStr("Un passage sans embuche ...");
						}
						if (activePlayer.getLife()<1) {
							break;
						}
					}
					else {
						continue;
					}
				}
				if (activePlayer.getLife()>=1) {
					in_out.printStr("======================\nBravo !!\n====================== ");
				}
				else {
					in_out.printStr("======================\nPan! t'es mort\n====================== ");
				}
			}
		}
	}


	/* ============================================================================
	  ==============================Fonctions "bas-niveau"=========================
	  ============================================================================
	 */

//	private void lifeModif(String name) {
//		int new_value = in_out.askInt(STR_LIFE_CHOICE);
//		Character perso = character_HMap.get(name);
//		perso.setLife(new_value);
//	}
//
//	private void attackModif(String name) {
//		int new_value = in_out.askInt(STR_ATTACK_CHOICE);
//		Character perso = character_HMap.get(name);
//		perso.setAttack(new_value);
//		//in_out.scan.nextLine();
//	}


	private void urlModif(String name) {
		String new_value = in_out.askString(STR_URL_CHOICE);
		Character perso = character_HMap.get(name);
		perso.setURL(new_value);
		//in_out.scan.nextLine();
		in_out.printStr(STR_SUCCESS);
	}

	private void equipmentModif(String name) {
		Character perso = character_HMap.get(name);
		String cmd = in_out.askString("souhaitez-vous modifier l'équipement d'(A)ttaque ou de (D)éfense");
		if (cmd.equals("A")) {
			String new_value = in_out.askString("Saisir le nom du " + perso.getLabelEquipementAttack());
			int int_new = in_out.askInt("Saisir la valeur d'attaque du  " + perso.getLabelEquipementAttack());
			perso.SetEquipementAttack(new_value, int_new);
			in_out.printStr(STR_SUCCESS);
		}
		else if (cmd.equals("D")) {
			String new_value = in_out.askString("Saisir le nom du " + perso.getLabelEquipementDefense());
			int int_new = in_out.askInt("Saisir la valeur d'attaque du  " + perso.getLabelEquipementDefense());
			perso.SetEquipementDefense(new_value, int_new);	
			in_out.printStr(STR_SUCCESS);
		}
		else {
			in_out.printStr(STR_INVALID);
		}
	}

	/** 
	 * 
	 * @return le nom d'un perso non existant (String)
	 */
	private String nameChoice() {
		g_character_name = in_out.askString(STR_NAME_CHOICE);
		Character perso = character_HMap.get(g_character_name);
		if (perso != null) {
			do {
				g_character_name = in_out.askString(STR_INVALID_NAME);
				perso = character_HMap.get(g_character_name);
			} while (perso != null);
		}
		return g_character_name;
	}
	/**
	 * @param question : la question à poser à l'utilisateur
	 * @param value_max  : La valeur max de la saisie "value"
	 * @param value_min : La valeur min de la saisie "value"
	 * @return un entier, la valeur verifiée
	 */
//	private int valueChoice(String question, int value_max, int value_min) {
//		int value = in_out.askInt(question);
//		if (value >= value_min && value <= value_max) {
//			return value;
//		} else {
//			return valueChoice(question, value_max, value_min);
//		}
//	}



}

