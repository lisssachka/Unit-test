package shop;
import java.util.*;

public class Shop {
    private List<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getCost() - o2.getCost();
            }
        });
        return products;
    }

    // Метод для добавления продукта в магазин
    public void addProduct(Product product){
        products.add(product);
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        Product max = new Product();
        max.setCost(0);
        for (Product product:products) {
            if (product.getCost() > max.getCost()){
                max = product;
            }
        }
        return max;
    }

}
