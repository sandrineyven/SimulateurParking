import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Gestion{

	public static void main(String args[]) throws IOException {
		
		//Initialisation du filtre, lecture des SD et initialisation des capteurs en fonction des SD
		Filtre filtre = new Filtre();
		String[] lecture0 = recupParam("res/sd0.txt");
		String[] lecture1 = recupParam("res/sd1.txt");
		String[] lecture2 = recupParam("res/sd2.txt");
		String[] lecture3 = recupParam("res/sd3.txt");
		Capteur capteur0 = new Capteur(Integer.parseInt(lecture0[0]),Integer.parseInt(lecture0[1]), lecture0[2]);
		Capteur capteur1 = new Capteur(Integer.parseInt(lecture1[0]),Integer.parseInt(lecture1[1]), lecture1[2]);
		Capteur capteur2 = new Capteur(Integer.parseInt(lecture2[0]),Integer.parseInt(lecture2[1]), lecture2[2]);
		Capteur capteur3 = new Capteur(Integer.parseInt(lecture3[0]),Integer.parseInt(lecture3[1]), lecture3[2]);

		
		//Lancement des diff�rents services
		//Chaque service contr�le un capteur
		Serveur service0 = new Serveur(capteur0, filtre, 0, capteur0.getValeur());
		Serveur service1 = new Serveur(capteur1, filtre, 1, capteur1.getValeur());
		Serveur service2 = new Serveur(capteur2, filtre, 2, capteur2.getValeur());
		Serveur service3 = new Serveur(capteur3, filtre, 3, capteur3.getValeur());
		
		service0.start();
		service1.start();
		service2.start();
		service3.start();
	
	}
	
	//Recuperation des parametres du fichier SD passe en parametre
		public static String[] recupParam(String nomFichier) throws IOException {
			String[] lecture= new String[3];
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
				if (nbLigne == 1) {
					lecture[0] = ligne.substring(6, ligne.length());
				}else if(nbLigne == 2) {
					lecture[1] = ligne.substring(6, ligne.length());
				}else if(nbLigne == 3) {
					lecture[2] = "res" + ligne.substring(7, ligne.length()) +".txt";
				}
			}
			lecteurAvecBuffer.close();
			return lecture;
		}
}
