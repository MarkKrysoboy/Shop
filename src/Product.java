import java.util.Objects;

public class Product { // Single-responsibility principle

    private String name;
    private String kind;
    private int price;

    public Product(String name, String kind, int price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  name + " (категория - " + kind + ")" +
                ", цена - " + price + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getPrice() == product.getPrice() && getName().equals(product.getName()) && Objects.equals(getKind(), product.getKind());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getKind(), getPrice());
    }
}
