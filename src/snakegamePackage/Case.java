package snakegamePackage;

public class Case implements Constantes{
	
	private int xIndice;
	private int yIndice;
	
	public Case(int xIndice, int yIndice){
		this.xIndice = xIndice;
		this.yIndice = yIndice;
	}
	
	public void setIndiceX(int x){
		this.xIndice = x;
	}
	public int getIndiceX(){
		return this.xIndice;
	}
	public void setIndiceY(int y){
		this.yIndice = y;
	}
	public int getIndiceY(){
		return this.yIndice;
	}
	
	public int getX(){
		return this.xIndice * CASE_EN_PIXEL;
	}
	public int getY(){
		return this.yIndice *CASE_EN_PIXEL;
	}
	public int getLargeur(){
		return CASE_EN_PIXEL;
	}
	public int getHauteur(){
		return CASE_EN_PIXEL;
	}
	
	public boolean estValide(){
		if(this.xIndice >=0 && this.xIndice < NBRE_DE_COLONNES)
			if(this.yIndice >=0 && this.yIndice < NBRE_DE_LIGNES)
				return true;
		return false;
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Case){
			Case box = (Case) obj;
			if(this.xIndice == box.xIndice && this.yIndice == box.yIndice)
				return true;
		}
		return false;
	}
}
