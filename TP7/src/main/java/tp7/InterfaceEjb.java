package tp7;

interface InterfaceEjb {
	void addProductToCart(Produit product); // ajout un produit à la liste du bean
	void checkOut(); // persistera les produits en base

}
