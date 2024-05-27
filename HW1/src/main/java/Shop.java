import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

public class Shop {
    ArrayList<Product> products;

    Shop() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public ArrayList<Product> sortProductsByPrice() {
        products.sort(Comparator.comparing(Product::getPrice));
        return products;
    }

    public Product getMostExpensiveProduct() {
        if(products.isEmpty()) {
            throw new IllegalArgumentException("В магазине нет продуктов");
        }
        Product result = products.get(0);
        for (int i = 1; i < products.size(); ++i) {
            if (products.get(i).getPrice() > result.getPrice()) {
                result = products.get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Product p1 = new Product("Хлеб", 30);
        Product p2 = new Product("Шоколад", 100);
        Product p3 = new Product("Пакет", 5);
        Product p4 = new Product("Мясо", 300);
        Product p5 = new Product("Вода", 60);

        shop.addProduct(p1);
        shop.addProduct(p2);
        shop.addProduct(p3);
        shop.addProduct(p4);
        shop.addProduct(p5);

        assertThat(shop.products.size()).isEqualTo(5);

        ArrayList<Product> expectedList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        assertThat(shop.products).containsExactlyInAnyOrderElementsOf(expectedList);

        assertThat(shop.getMostExpensiveProduct()).isEqualTo(p4);
        Shop emptyShop = new Shop();
        assertThatThrownBy(emptyShop::getMostExpensiveProduct).isInstanceOf(IllegalArgumentException.class);
        Shop shop2 = new Shop();
        shop2.addProduct(p1);
        assertThat(shop2.getMostExpensiveProduct()).isEqualTo(p1);
        ArrayList<Product> expectedOrderList = new ArrayList<>(Arrays.asList(p3, p1, p5, p2, p4));
        assertThat(shop.sortProductsByPrice()).containsExactlyElementsOf(expectedOrderList);
    }
}
