package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Quel produit voulez-vous acheter ?\n");
			String produit = scan.nextLine();
			if (controlAcheterProduit.vendeursProduit(produit) == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.\n");
			} else {
				StringBuilder question = new StringBuilder();
				question.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
				for (int i = 0; i < controlAcheterProduit.vendeursProduit(produit).length; i++) {
					question.append(
							(i + 1) + " - " + controlAcheterProduit.vendeursProduit(produit)[i].getNom() + "\n");
				}
				System.out.println(question);
				int numVendeur = scan.nextInt();
				if (numVendeur > controlAcheterProduit.vendeursProduit(produit).length || numVendeur <= 0) {
					System.out.println("Ce vendeur n'est pas proposé !\n");
				} else {
					String nomVendeur = controlAcheterProduit.vendeursProduit(produit)[numVendeur - 1].getNom();
					System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + "\n");
					System.out.println("Bonjour " + nomAcheteur + "\n");
					System.out.println("Combien de fleurs voulez-vous acheter ?\n");
					int nbProduit = scan.nextInt();
					int nbProduitVendu = controlAcheterProduit.acheterProduit(nomVendeur, nbProduit);
					if (nbProduitVendu == -1) {
						System.out.println("Je suis désolé " + nomVendeur
								+ " mais il faut êre un habitant du village pour commercer ici.\n");
					} else if (nbProduitVendu == 0) {
						System.out.println(nomAcheteur + " veux acheter " + nbProduit + " " + produit
								+ ", malheureusement il n'y en a plus !\n");
					} else if (nbProduitVendu < nbProduit) {
						System.out.println(nomAcheteur + " veux acheter " + nbProduit + " " + produit
								+ ", malheureusement " + nomVendeur + " n'en a plus que " + nbProduitVendu + ". "
								+ nomAcheteur + " achète tout le stock de " + nomVendeur + ".\n");
					} else {
						System.out.println(
								nomAcheteur + " achète " + nbProduitVendu + " " + produit + " à " + nomVendeur + ".\n");
					}
				}

			}
		}
		else {
			System.out.println("Désolé, il faut être un habitant du village pour acheter dans le marché !\n");
		}
	}
}
