import java.util.Scanner;

public class AdderRemoverProduct {

    Products warehouse;
    Products basket;
    int input;

    public AdderRemoverProduct(Products warehouse, Products basket) {
        this.warehouse = warehouse;
        this.basket = basket;
    }

    Scanner scanner = new Scanner(System.in);

    public void addAndRemove() {
        Product product = warehouse.productList.get(input - 1);
        int count = scanner.nextInt();
        basket.addProduct(product, count);
        warehouse.removeProduct(product, count);
    }

    public void adding() {
        while (true) {
            System.out.println("Выберите номер товара для покупки и его количество через пробел(\"ноль\" для выхода):");
            warehouse.display();
            input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            addAndRemove();
            System.out.println("В Вашей корзине:");
            basket.display();
            System.out.println();
        }
    }

    public void refund() {
        while (true) {
            System.out.println("В Вашей корзине:");
            warehouse.display();
            System.out.println("Выберите номер товара для возврата и его количество через пробел(\"ноль\" для выхода):");
            input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            addAndRemove();
            System.out.println();
        }
    }
}
