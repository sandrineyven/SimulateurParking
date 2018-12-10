
public class Filtre {
	
	public Filtre() {
		
	}

	public String filtreF2(boolean valeur, boolean derniereValeur) {
		if (derniereValeur != valeur)
		{
			if (valeur)
			{
				return "1";
			}
			else return "0";
		}
		else return null;
	}

	public String filtreF1(boolean valeur) {
		if (valeur)
		{
			return "D";
		}
		else return "N";
	}
	
}
