package kiosk.product;

public class MemoryProductRepository implements ProductRepository {

    private Product[] products = {
            new Product(0, "불고기버거", Category.HAMBERGER, Size.ONE_SIZE, 3000, 555),
            new Product(1, "새우버거", Category.HAMBERGER, Size.ONE_SIZE, 3300, 444),
            new Product(2, "치킨버거", Category.HAMBERGER, Size.ONE_SIZE, 3500, 543),
            new Product(3, "감자튀김(R)", Category.SIDE, Size.REGULAR, 1000, 300),
            new Product(4, "감자튀김(L)", Category.SIDE, Size.LARGE, 1500, 400),
            new Product(5, "치킨너겟", Category.SIDE, Size.ONE_SIZE, 2000, 500),
            new Product(6, "코카콜라(R)", Category.DRINK, Size.REGULAR, 1000, 200),
            new Product(7, "코카콜라(L)", Category.DRINK, Size.LARGE, 1500, 300),
            new Product(8, "제로콜라(R)", Category.DRINK, Size.REGULAR, 1000, 0),
            new Product(9, "제로콜라(L)", Category.DRINK, Size.LARGE, 1500, 0)
    };

    public Product[] getProducts() {
        return products;
    }
}
