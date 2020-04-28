package dnd;

public class Wizzard{
	String nom;
	String imageURL;
	int niveauDeVie;
	int forceAttaque;
	Sort sort;
	Philtre philtre;


	//Constructeur par defaut
	public Wizzard () {
		nom = "Inconnu";
		imageURL = "Pas d'image";
		niveauDeVie = 10;
		forceAttaque = 10;
		sort = new Sort();
		philtre = new Philtre();

	}

	//Constructeur moit'
	public Wizzard (String name) {
		nom = name;
		imageURL = "Pas d'image";
		niveauDeVie = 10;
		forceAttaque = 10;
		sort = new Sort();
		philtre = new Philtre();

	}

	//Constructeur complet
	public Wizzard (String name, String url, int life, int attack) {
		nom = name;
		imageURL = url;
		niveauDeVie = life;
		forceAttaque = attack;
		sort = new Sort();
		philtre = new Philtre();

	}


}
