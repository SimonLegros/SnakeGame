package snakegamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Grenouille extends Case{
	private static final Random RND = new Random();
	
	public Grenouille(){
		super(getRandomX(), getRandomY());
	}
	
	private static int getRandomX(){
		return RND.nextInt(NBRE_DE_COLONNES);
	}
	private static int getRandomY(){
		return RND.nextInt(NBRE_DE_LIGNES);
	}
	
	public void nouvelleGrenouille(){
		setIndiceX(getRandomX());
		setIndiceY(getRandomY());
	}
	
	public void affichage(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(getX()+2, getY()+2, getLargeur() - 4, getHauteur() - 4);
	}
}
