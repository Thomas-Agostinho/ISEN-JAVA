package tp7;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import tp7.PanierEjb;

@WebServlet("/ShopControl")
public class ShopControl extends HttpServlet {
    @EJB
    private PanierEjb panierEjb;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Afficher le formulaire de saisie et la liste des produits du panier
        List<Produit> produits = panierEjb.getProduits(); // Obtenez la liste des produits du panier

        // Transférez le contrôle à la JSP en utilisant le bon emplacement
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("/WEB-INF/shopweb.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); // Obtenez l'action de l'utilisateur

        if ("ajouter".equals(action)) {
            // Gérer l'action "ajouter un produit"
            Produit nouveauProduit = new Produit();
            // Initialisez nouveauProduit avec les détails du produit depuis les paramètres de la requête
            panierEjb.addProductToCart(nouveauProduit); // Ajoutez le produit au panier
        } else if ("finaliser".equals(action)) {
            // Gérer l'action "finaliser la commande"
            panierEjb.checkOut(); // Persister les produits en base de données
        }

        // Redirigez l'utilisateur vers la page principale après l'action
        response.sendRedirect(request.getContextPath() + "/ShopControl");
    }
}
