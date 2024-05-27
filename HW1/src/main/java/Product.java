import java.util.Objects;

public class Product {
    private String Name;
    private Integer Price;

    Product(String Name, Integer Price) {
        this.Name = Name;
        this.Price = Price;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(Name, product.Name) && Objects.equals(Price, product.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Price);
    }
}
