import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Products warehouse = new Products();
        Products basket = new Products();
        AdderRemoverProduct adder;
        SaveOrder saveOrder = new ConsolleSaveOrder();
        int idOrder = 1;
        warehouse.addProduct(new Product("Soul", "Food", 90), 100);
        warehouse.addProduct(new Product("Bread", "Food", 320), 200);
        warehouse.addProduct(new Product("Bread", "Food", 320), 100);
        warehouse.addProduct(new Product("Spoon", "Not food", 120), 500);

        warehouse.addProduct(new Product("Soul", "Food", 90), 100);
        warehouse.removeProduct(new Product("Soul", "Food", 90), 50);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Здравствуйте! Что бы вы хотели сделать (для выхода введите \"end\" ):");
            System.out.println("1. Купить товары");
            System.out.println("2. Вернуть товар");
            System.out.println("3. Сделать заказ");
            System.out.println("4. Показать все продовольственные товары");
            System.out.println("5. Показать все непродовольственные товары");

            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                break;
            }
            switch (inputString) {
                case ("1"):
                    adder = new AdderRemoverProduct(warehouse, basket);
                    adder.adding();
                    break;
                case ("2"):
                    System.out.println("Выберите товары для возврата:");
                    adder = new AdderRemoverProduct(basket, warehouse);
                    adder.refund();
                    break;
                case ("3"):
                    System.out.println("В корзине:");
                    basket.display();
                    System.out.println("Для срочного заказа введите 1, для обычного 2:");
                    inputString = scanner.nextLine();
                    Order order;
                    if (Integer.parseInt(inputString) == 1) {
                        idOrder++;
                        order = new UrgentOrder(idOrder, basket, "20.02.2022");

                    } else {
                        idOrder++;
                        order = new Order(idOrder, basket);
                    }
                    order.displayOrder();
                    saveOrder.save(order);
                    break;
                case ("4"):
                    System.out.println("Продовольственные товары:");
                    warehouse.filter("Food");
                    break;
                case ("5"):
                    System.out.println("Непродовольственные товары:");
                    warehouse.filter("Not food");
                    break;
            }


        }
    }
}







