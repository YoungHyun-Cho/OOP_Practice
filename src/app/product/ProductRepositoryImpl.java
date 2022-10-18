package app.product;

import app.product.subproduct.BurgerSet;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

/*
* 상품 정보에 접근하는 객체를 여기에 정의하였습니다.
*
* 콘텐츠에서는 이러한 패턴에 대해 자세하게 설명할 예정은 아니지만,
* 이렇게 설계했을 때 어떤 장점이 생기는지 설명하고자 합니다.
*
* 추가적으로, 정식님 의견대로 세션에서 DB를 교체하는 것을 보여주면서 DB를 교체했음에도
* 코드는 극히 일부만 변경해도 된다는 점을 보여주는 것도 고려하고 있습니다.
* */

public class ProductRepositoryImpl implements ProductRepository {

    private Product[] products = {
            new Hamburger(1, "새우버거", 3500, 500, false, 4500),
            new Hamburger(2, "치킨버거", 4000, 600, false, 5000),
            new Side(3, "감자튀김", 1000, 300, 1),
            new Side(4, "어니언링", 1000, 300, 1),
            new Drink(5, "코카콜라", 1000, 200, true),
            new Drink(6, "제로콜라", 1000, 0, true),
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
