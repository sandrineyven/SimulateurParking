
public class Gestion{

	public static void main(String args[]) {
		
		Filtre filtre = new Filtre();
		Capteur capteur0 = new Capteur(lecture0[0], lecture0[1], lecture0[2]);
		Capteur capteur1 = new Capteur(lecture1[0], lecture1[1], lecture1[2]);
		Capteur capteur2 = new Capteur(lecture2[0], lecture2[1], lecture2[2]);
		Capteur capteur3 = new Capteur(lecture3[0], lecture3[1], lecture3[2]);
	
		Serveur service0 = new Serveur(capteur0, filtre, 0, null);
		Serveur service1 = new Serveur(capteur1, filtre, 1, null);
		Serveur service2 = new Serveur(capteur2, filtre, 2, null);
		Serveur service3 = new Serveur(capteur3, filtre, 3, null);
	
	}
}
