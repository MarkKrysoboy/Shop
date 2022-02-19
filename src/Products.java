import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Products implements Filtrable {  // Open-closed principle
    List<Product> productList = new ArrayList<>();
    List<Integer> quantityList = new ArrayList<>();
    boolean remove;

    public void addProduct(Product product, int quantity) { // DRY (Don’t Repeat Yourself)
        if (!productList.contains(product)) {
            productList.add(product);
            quantityList.add(quantity);
        } else {
            int index = productList.indexOf(product);
            if (remove) {
                quantityList.set(index, quantityList.get(index) + quantity);
            }
        }
    }

    public void removeProduct(Product product, int quantity) {
        if (productList.contains(product)) {
            int index = productList.indexOf(product);
            int remains = quantityList.get(index) - quantity;
            if (remains < 0) {
                System.out.println("Такого количества продукта нет! в наличии - " + quantityList.get(index));
                remove = false;
            } else if (remains == 0) {
                productList.remove(product);
                quantityList.remove(index);
                remove = true;
            } else {
                quantityList.set(index, remains);
                remove = true;
            }
        } else {
            System.out.println("Такого продукта нет!");
        }

    }

    public void display() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i) + " - " + quantityList.get(i) + " шт.");
        }
    }

    public int summ() {
        int summ = 0;
        for (int i = 0; i < productList.size(); i++) {
            summ += productList.get(i).getPrice() * quantityList.get(i);
        }
        return summ;
    }

    @Override
    public void filter(String str) {
        productList.stream()
                .filter(product -> product.getKind() == str)
                .forEach(System.out::println);
    }

    public void arrayProducts (){
        Product[] arrayProducts = new Product[productList.size()]; // Magic numbers
        productList.toArray(arrayProducts);
    }
}
