package kiosk;

import kiosk.product.Product;

public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    public void printMenu() {
        for (int i = 1; i <= products.length; i++) {
            System.out.printf(
                    "(%d) %20s %10d %10d\n",
                    i, products[i].getName(), products[i].getPrice(), products[i].getKcal()
            );
        }
    }
}
