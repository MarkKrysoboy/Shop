public class Order {

    private int id;
    Products products;

    public Order(int id, Products products) {
        this.id = id;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Заказ №" + id +
                ", сумма заказа - " + products.summ() +
                ", количество позиций - " + products.productList.size();
    }

    public void displayOrder() {
        System.out.println("Вы заказали:");
        products.display();
        System.out.println(toString());
    }
}
