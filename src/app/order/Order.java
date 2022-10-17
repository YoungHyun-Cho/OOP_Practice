package app.order;

import app.product.Product;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", products=" + Arrays.toString(products) +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
