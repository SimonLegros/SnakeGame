package snakegamePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JOptionPane;

import snakegamePackage.Constantes.Direction;

public class Modele {
	
	private Snake serpent;
	private Grenouille grenouille;
	
	private boolean partieTerminee;
	
	public Modele(){
		serpent = new Snake();
		partieTerminee = false;
		grenouille = new Grenouille();
	}
	
	//calcul du jeu
	public void calcul(){
		if(!this.partieTerminee){
			this.serpent.calcul(this.grenouille);
			if(this.serpent.estMort()){
				this.partieTerminee = true;
			}
		}
	}
	//dessin graphique du jeu
	public void affichage(Graphics g){
		this.serpent.affichage(g);
		this.grenouille.affichage(g);
		if(this.partieTerminee){
			String str = "Partie terminée";
			g.setColor(Color.RED);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
			FontMetrics fm = g.getFontMetrics();
			int x = (g.getClipBounds().width - fm.stringWidth(str)) / 2;
			int y = (g.getClipBounds().height / 2) - fm.getMaxDescent();
			g.drawString(str, x, y);
		}
		//affichage du niveau
		g.setColor(Color.BLUE);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.drawString(String.valueOf(getNiveau()), 5, 25);
	}
	
	public void gestionDuClavier(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) { // touche flèche droite
        	this.serpent.setDemandeClavier(Direction.VERS_LA_DROITE);
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT) { // touche flèche gauche
        	this.serpent.setDemandeClavier(Direction.VERS_LA_GAUCHE);
        } else if (event.getKeyCode() == KeyEvent.VK_UP) { // touche flèche haut
        	this.serpent.setDemandeClavier(Direction.VERS_LE_HAUT);
        } else if (event.getKeyCode() == KeyEvent.VK_DOWN) { // touche flèche bas
        	this.serpent.setDemandeClavier(Direction.VERS_LE_BAS);
        }
	}
	private int getNiveau(){
		return(this.serpent.getEatCount()) + 1;
	}
	public int getTemporisation() {
	      switch (getNiveau()) {
	            case 1:
	            case 2:
	                  return 200;
	            case 3:
	            case 4:
	                  return 175;
	            case 5:
	            case 6:
	                  return 150;
	            case 7:
	            case 8:
	                  return 125;
	            case 9:
	                  return 100;
	            default:
	                  return 85;
	      }
	}
}
 