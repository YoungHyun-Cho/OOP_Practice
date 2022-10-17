package app.product;

import app.member.Member;

public class MemoryProductRepository implements ProductRepository {

    private Product[] products = {
            new Product(0, "한우버거",     3000, 555),
            new Product(1, "새우버거",     3300, 444),
            new Product(2, "치킨버거",     3500, 543),
            new Product(3, "감자튀김 (R)", 1000, 300),
            new Product(4, "감자튀김 (L)", 1500, 400),
            new Product(5, "코카콜라 (R)", 1000, 200),
            new Product(6, "코카콜라 (L)", 1500, 300),
            new Product(7, "제로콜라 (R)", 1000, 0),
            new Product(8, "제로콜라 (L)", 1500, 0)
    };

    @Override
    public Product[] findAll() {
        return products;
    }

    @Override
    public Product findById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) return product;
        }
        return null;
    }
}
