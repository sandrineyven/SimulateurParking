import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Capteur {

	int id;
	int frequence;
	String nomFichierCapteur;
	boolean valeur;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@SuppressWarnings("null")
	public Capteur(int id, int frequence, String nomFichierCapteur) {
		this.id = id;
		this.frequence = frequence;
		this.nomFichierCapteur = nomFichierCapteur;
	}

	//Lecture de la valeur du capteur
	public void actualiser() throws IOException {
		BufferedReader lecteurAvecBuffer = null;
		String ligne;

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(nomFichierCapteur));
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			if (ligne.charAt(ligne.length() - 1) == '1') {
				this.valeur = true;
			}else {
				this.valeur = false;
			}
		}
		lecteurAvecBuffer.close();
	}


	
	
	//Getteurs et setteurs

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	public String getNomFichierCapteur() {
		return nomFichierCapteur;
	}

	public void setNomFichierCapteur(String nomFichierCapteur) {
		this.nomFichierCapteur = nomFichierCapteur;
	}

	public boolean getValeur() {
		return valeur;
	}

	public void setValeur(boolean valeur) {
		this.valeur = valeur;
	}
	
	 
	
	

}
