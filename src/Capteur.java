import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Capteur {

	private int id;
	private int frequence;
	private String nomFichierCapteur;
	private int valeur;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Capteur(int id, int frequence, String nomFichierCapteur) {
		this.id = id;
		this.frequence = frequence;
		this.nomFichierCapteur = nomFichierCapteur;
		this.valeur=2;
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
			//Si la valeur lue n'est pas 0 ou 1 on arrete le thread avec l'assert et une erreur est levee
			assert ligne.charAt(ligne.length() - 1)=='0' || ligne.charAt(ligne.length() - 1)=='1': "La valeur du capteur n'est pas valide";
			if (ligne.charAt(ligne.length() - 1) == '1') {
				this.valeur = 1;
			}else if(ligne.charAt(ligne.length() - 1) == '0'){
				this.valeur = 0;
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

	public int getValeur() {
		return valeur;
	}
	
	 
	
	

}
