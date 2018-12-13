import java.io.IOException;

public class Serveur extends Thread{

	private Capteur capteur;
	private Filtre filtre;
	private int numFiltre;
	private boolean derniereValeur;
	
	
	public Serveur(Capteur capteur, Filtre filtre, int numFiltre, boolean derniereValeur) {
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
		
		if (numFiltre == 0)
		{
			if (capteur.getValeur())
			{
				System.out.println("Capteur "+ capteur.getId() + " : 1");
			}
			else System.out.println("Capteur "+ capteur.getId() + " : 0");
			
		}
		else {
			if (numFiltre == 1 )
			{
				String placeLibre = filtre.filtreF1(capteur.getValeur());
				System.out.println("Capteur "+ capteur.getId() + " : " + placeLibre);
				
			}
			
			if(numFiltre == 2)
			{
				String repeterOuNon = filtre.filtreF2(capteur.getValeur(),derniereValeur);
				if(repeterOuNon != null)
				{
					System.out.println("Capteur "+ capteur.getId() + " : " + repeterOuNon);
				}
				derniereValeur = capteur.getValeur();
			}
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
