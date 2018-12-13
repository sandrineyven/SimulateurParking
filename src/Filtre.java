public class Filtre {
	
	public Filtre() {
		
	}

	public String filtreF2(int valeur, int derniereValeur) {
		assert valeur==1||valeur==0 : "La valeur du capteur n'est pas valide";
		if (derniereValeur != valeur)
		{
			return String.valueOf(valeur);
		}
		else return null;
	}

	public String filtreF1(int valeur) {
		assert valeur==1||valeur==0 : "La valeur du capteur n'est pas valide";
		if (valeur==1)
		{
			return "D";
		}
		else if(valeur==0) return "N";
		return "La valeur du capteur n'est pas valide";
	}
	
}
