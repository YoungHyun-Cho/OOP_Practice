package app.product;

public interface ProductRepository {
    Product[] findAll();
    Product findById(int productId);
}
