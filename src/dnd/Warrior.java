package dnd;

public class Warrior{
	String nom;
	String imageURL;
	int niveauDeVie;
	int forceAttaque;
	Arme arme;
	Bouclier bouclier;

	//Constructeur par defaut
	public Warrior () {
		nom = "Inconnu";
		imageURL = "Pas d'image";
		niveauDeVie = 10;
		forceAttaque = 10;
		arme = new Arme();
		bouclier = new Bouclier();

	}

	//Constructeur moit'
	public Warrior (String name) {
		nom = name;
		imageURL = "Pas d'image";
		niveauDeVie = 10;
		forceAttaque = 10;
		arme = new Arme();
		bouclier = new Bouclier();

	}

	//Constructeur complet
	public Warrior (String name, String url, int life, int attack) {
		nom = name;
		imageURL = url;
		niveauDeVie = life;
		forceAttaque = attack;
		arme = new Arme();
		bouclier = new Bouclier();

	}
}
