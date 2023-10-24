<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mon Panier</title>
</head>
<body>
    <h1>Mon Panier</h1>
    <form action="ShopControl" method="post">
        <!-- Formulaire pour ajouter un produit -->
        <input type="text" name="nomProduit" placeholder="Nom du produit">
        <!-- Autres champs du produit (code, description, etc.) -->
        <input type="submit" name="action" value="ajouter" />
    </form>
    <ul>
        <!-- Liste des produits dans le panier -->
        <c:forEach items="${produits}" var="Produit">
            <li>${Produit.nomProduit} - ${Produit.description}</li>
        </c:forEach>
    </ul>
    <form action="ShopControl" method="post">
        <input type="submit" name="action" value="finaliser" />
    </form>
</body>
</html>
