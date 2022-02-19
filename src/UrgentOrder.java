import java.util.Date;

public class UrgentOrder extends Order{ // Liskov substitution principle

    private String termExecution;

    public UrgentOrder(int id, Products productList, String termExecution) {
        super(id, productList);
        this.termExecution = termExecution;
    }

    @Override
    public String toString() {
        return "Заказ №" + getId() +
                ", сумма заказа - " + products.summ() +
                ", количество позиций - " + products.productList.size() +
                ", дата исполнения - " + termExecution;
    }
}
