public class ConsolleSaveOrder implements SaveOrder{

    void toConsole(Order order){
        System.out.println(order.toString());
    }

    @Override
    public void save(Order order) { // Dependency inversion principle
        toConsole(order);
    }
}
