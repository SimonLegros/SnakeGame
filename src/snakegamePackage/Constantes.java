package snakegamePackage;

public interface Constantes {
	//surface de jeu : 30 colonnes
	public static final int NBRE_DE_COLONNES = 30;
	
	//surface de jeu: 30 lignes
	public static final int NBRE_DE_LIGNES = 30;
	
	//dimension d'une case en pixels
	public static final int CASE_EN_PIXEL = 15;
	
	public static final int DELAY = 250;
	public enum Direction{
		VERS_LE_HAUT,
		VERS_LA_DROITE,
		VERS_LE_BAS,
		VERS_LA_GAUCHE;
	}
}
