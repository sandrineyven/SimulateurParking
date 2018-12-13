import java.io.IOException;

public class Serveur extends Thread{

	private Capteur capteur;
	private Filtre filtre;
	private int numFiltre;
	private int derniereValeur;
	
	
	public Serveur(Capteur capteur, Filtre filtre, int numFiltre, int derniereValeur) {
		super();
		this.capteur = capteur;
		this.filtre = filtre;
		this.numFiltre = numFiltre;
		this.derniereValeur = derniereValeur;
	}


	public void sortie() {
		try {
			capteur.actualiser();
		} catch (IOException e) {
			System.out.print("L'actualisation de la donnee a echouee.");
			e.printStackTrace();
		}
		//Pas de filtre
		if (numFiltre == 0)
		{
			if (capteur.getValeur()==1)
			{
				System.out.println("Capteur "+ capteur.getId() + " : 1");
			}
			else System.out.println("Capteur "+ capteur.getId() + " : 0");
			
		}
		
		else {
			//Filtre 1 (renvoie D si 1 ou N si 0)
			if (numFiltre == 1 )
			{
				String placeLibre = filtre.filtreF1(capteur.getValeur());
				System.out.println("Capteur "+ capteur.getId() + " : " + placeLibre);
				
			}
			//Filtre 2 (réécrit seulement si la valeur a changé)
			if(numFiltre == 2)
			{
				String repeterOuNon = filtre.filtreF2(capteur.getValeur(),derniereValeur);
				if(repeterOuNon != null)
				{
					System.out.println("Capteur "+ capteur.getId() + " : " + repeterOuNon);
				}
				derniereValeur = capteur.getValeur();
			}
			//Filtre 1+2 (réécrit seulement si la valeur a changé en D ou N)
			if(numFiltre == 3 )
			{
				String repeterOuNon = filtre.filtreF2(capteur.getValeur(),derniereValeur);
				if(repeterOuNon != null)
				{
					String placeLibre = filtre.filtreF1(capteur.getValeur());
					System.out.println("Capteur "+ capteur.getId() + " : " + placeLibre);
				}
				derniereValeur = capteur.getValeur();
			}
		}
		
			
	}
	
	public void run() {
		super.run();
		
		while (true) {
			sortie();
			
			try {
				Thread.sleep(capteur.getFrequence());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
