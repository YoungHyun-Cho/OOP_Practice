package app;

import app.product.ProductRepositoryImpl;
import app.product.ProductService;

public class AppConfigurer {
    private String storeName = "🍔 Burger Queen";

    public String getStoreName() {
        return storeName;
    }

    public ProductService productService() {
        return new ProductService(new ProductRepositoryImpl());
    }
}