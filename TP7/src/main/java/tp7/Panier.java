package tp7;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Produit> produits = new ArrayList<>();

    public List<Produit> getProduits() {
        return produits;
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void supprimerProduit(Produit produit) {
        produits.remove(produit);
    }
}
