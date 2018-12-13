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

	public Capteur(int id) {
		this.id = id;
		try {
			recupFichierCapteur(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.valeur = actualiser();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Lecture de la valeur du capteur
	public boolean actualiser() throws IOException {
		BufferedReader lecteurAvecBuffer = null;
		String ligne;

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(nomFichierCapteur));
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			if (ligne.charAt(ligne.length() - 1) == '1') {
				return true;
			}
		}
		lecteurAvecBuffer.close();
		return false;
	}

	//Recuperation du bon fichier selon le capteur choisi
	public void recupFichierCapteur(int id) throws IOException {
		this.nomFichierCapteur = null;
		String nomFichierParam = null;
		switch (id) {
		case 0:
			nomFichierParam = "res/sd0.txt";
			break;
		case 1:
			nomFichierParam = "res/sd1.txt";
			break;
		case 2:
			nomFichierParam = "res/sd2.txt";
			break;
		case 3:
			nomFichierParam = "res/sd3.txt";
			break;
		}
		if (nomFichierParam != null) {
			recupParam(nomFichierParam);
		} else {
			System.out.println("Fichier introuvable");
		}
	}

	//Recuperation de la frequence a laquelle on va lire les valeurs du capteur
	public void recupParam(String nomFichier) throws IOException {
		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		int nbLigne = 0;
		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(nomFichier));
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			nbLigne++;
			if (nbLigne == 2) {
				this.frequence = Integer.parseInt(ligne.substring(6, ligne.length()));
			}else if(nbLigne == 3) {
				this.nomFichierCapteur = "res" + ligne.substring(7, ligne.length()) +".txt";
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
