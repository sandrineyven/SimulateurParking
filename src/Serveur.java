
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
		capteur.actualiser();
		
		if (numFiltre == 0)
		{
			if (capteur.getValeur())
			{
				System.out.println("Capteur "+ capteur.getId() + " : 1");
			}
			else System.out.println("Capteur "+ capteur.getId() + " : 0");
			
		}
		else {
			if (numFiltre == 1  || numFiltre == 3)
			{
				String placeLibre = filtre.filtreF1(capteur.getValeur());
				System.out.println("Capteur "+ capteur.getId() + " : " + placeLibre);
				
			}
			
			if(numFiltre == 2  || numFiltre == 3)
			{
				String repeterOuNon = filtre.filtreF2(capteur.getValeur(),derniereValeur);
				if(repeterOuNon != null)
				{
					System.out.println("Capteur "+ capteur.getId() + " : " + repeterOuNon);
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
