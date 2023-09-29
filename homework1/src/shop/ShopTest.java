package shop;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов,
   верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        Product product1 = new Product(15, "Milk");
        Product product2 = new Product(10, "Ball");
        List<Product> basket = new ArrayList<>();
        basket.add(product2);
        basket.add(product1);

        Shop shop = new Shop();
        shop.addProduct(product1);
        shop.addProduct(product2);

        // Верный ли список продуктов
        assertThat(shop.getProducts()).hasSameElementsAs(basket);
        // Верно ли находит самый дорогой продукт
        assertThat(shop.getMostExpensiveProduct()).isEqualTo((product1));
        // Верно ли сортирует
        shop.sortProductsByPrice();
        assertThat(shop.getProducts()).isSortedAccordingTo(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getCost() - o2.getCost();
            }
        });
    }
}