package app.product;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product[] getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProduct(int productId) {
        return productRepository.findById(productId);
    }
}
