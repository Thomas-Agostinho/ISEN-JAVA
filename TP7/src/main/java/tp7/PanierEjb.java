package tp7;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class PanierEjb implements InterfaceEjb {

    @PersistenceContext
    private EntityManager entityManager;

    private List<Produit> panier = new ArrayList<>();

    @Override
    public void addProductToCart(Produit product) {
        // Ajouter le produit au panier en mémoire
        panier.add(product);
    }

    @Transactional
    @Override
    public void checkOut() {
        // Persister les produits du panier en base de données (utilisation de JPA)
        for (Produit product : panier) {
            entityManager.persist(product);
        }
        panier.clear(); // Vider le panier après l'achat
    }
}

