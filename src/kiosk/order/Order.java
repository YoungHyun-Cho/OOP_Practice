package kiosk.order;

import kiosk.product.Product;

public class Order {
    private int id;
    private int memberId;
    private Product[] products;
    private int finalPrice;

    public Order(int id, int memberId, Product[] products, int finalPrice) {
        this.id = id;
        this.memberId = memberId;
        this.products = products;
        this.finalPrice = finalPrice;
    }

    public int getId() {
        return id;
    }

    public Product[] getProducts() {
        return products;
    }

    public int getFinalPrice() {
        return finalPrice;
    }
}
