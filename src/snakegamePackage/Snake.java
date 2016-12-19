package snakegamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;


public class Snake implements Constantes{

	private LinkedList<Case> list;
	private Direction direction;
	private Direction demande;
	private boolean estMort;
	private int eatCount;
	
	public Snake() {
        this.list = new LinkedList<Case>();
        this.list.add(new Case(14, 15));
        this.list.add(new Case(15, 15));
        this.list.add(new Case(16, 15));
        this.direction = Direction.VERS_LA_GAUCHE; //direction initiale
	}
  
	public void calcul(Grenouille grenouille) {
	      // calcul du serpent
		tourner();
		if(peutManger(grenouille)){
			manger();
			grenouille.nouvelleGrenouille();
		}
		else if(peutAvancer())
			avance();
		else{
			this.estMort = true;
		}
	}

	public void affichage(Graphics g) {
	    // dessin du serpent
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING	, RenderingHints.VALUE_ANTIALIAS_ON);
		for(Case box : this.list){
			g.setColor(Color.cyan);
			g.fillOval(box.getX(), box.getY(), box.getLargeur(), box.getHauteur());
		}
	}
	
	private Case getNextcase() {
	      Case tete = this.list.getFirst();
	      switch (this.direction) {
	            case VERS_LE_HAUT:
	                  return new Case(tete.getIndiceX(), tete.getIndiceY() - 1);
	            case VERS_LA_DROITE:
	                  return new Case(tete.getIndiceX() + 1, tete.getIndiceY());
	            case VERS_LE_BAS:
	                  return new Case(tete.getIndiceX(), tete.getIndiceY() + 1);
	            case VERS_LA_GAUCHE:
	                  return new Case(tete.getIndiceX() - 1, tete.getIndiceY());
	      }
	      return null;
	}
	
	private void avance() {
	      // ajoute en tête de liste la case sur laquelle
	      // le serpent doit se déplacer
	      this.list.addFirst(getNextcase());
	      // supprime le dernier élément de la liste
	      this.list.removeLast();
	}
	
	private boolean peutAvancer(){
		Case nextCase = getNextcase();
		return getNextcase().estValide() && !this.list.contains(nextCase);
	}
	
	public boolean estMort(){
		return this.estMort;
	}
	
	public void setDemandeClavier(Direction demande){
		this.demande = demande;
	}
	private void tourner() {
	      if (this.demande != null) { // une touche à été pressée
	            // le serpent va vers le haut ou le bas
	            if (this.direction == Direction.VERS_LE_HAUT
	                        || this.direction == Direction.VERS_LE_BAS) {
	                  if (this.demande == Direction.VERS_LA_DROITE) { // la touche droite
	                                                               // à été pressée
	                        // le serpent tourne à droite
	                        this.direction = Direction.VERS_LA_DROITE;
	                  } else if (this.demande == Direction.VERS_LA_GAUCHE) { // la touche
	                                                                      // gauche à
	                                                                      // été pressée
	                        // le serpent tourne à gauche
	                        this.direction = Direction.VERS_LA_GAUCHE;
	                  }
	            } else { // le serpent va vers la droite ou la gauche
	                  if (this.demande == Direction.VERS_LE_HAUT) { // la touche haut à
	                                                             // été pressée
	                        // le serpent tourne vers le haut
	                        this.direction = Direction.VERS_LE_HAUT;
	                  } else if (this.demande == Direction.VERS_LE_BAS) { // la touche bas
	                                                                   // à été pressée
	                        // le serpent tourne vers le bas
	                        this.direction = Direction.VERS_LE_BAS;
	                  }
	            }
	            // nous avons tenu compte du clavier, nous le vidons afin de
	            // forcer le joueur a réappuyé sur une touche pour demander
	            // une autre direction
	            this.demande = null;
	      }
	}
	
	private void manger(){
		this.list.addFirst(getNextcase());
		this.eatCount++;
	}
	private boolean peutManger(Grenouille grenouille){
		Case nextCase = getNextcase();
		return grenouille.equals(getNextcase());
	}
	
	public int getEatCount(){
		return this.eatCount;
	}
}
