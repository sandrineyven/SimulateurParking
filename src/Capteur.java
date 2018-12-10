
public class Capteur {
	int id;
	boolean valeur;
	int frequence;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getValeur() {
		return valeur;
	}
	public void setValeur(boolean valeur) {
		this.valeur = valeur;
	}
	public int getFrequence() {
		return frequence;
	}
	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}
	
	public Capteur(int id, boolean valeur, int frequence) {
		super();
		this.id = id;
		this.valeur = valeur;
		this.frequence = frequence;
	}
	
	public void actualiser() {
		
	}
	
	
	


}
