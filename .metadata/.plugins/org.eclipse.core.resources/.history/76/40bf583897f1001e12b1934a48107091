package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
		
	public Gaulois[] vendeursProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}

	public int acheterProduit(String nomVendeur, int nb) {
		if (controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(nb);
		}
		return -1;
	}
}
