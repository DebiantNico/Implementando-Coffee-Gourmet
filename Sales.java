import java.util.ArrayList;
//import java.util.Iterator;


public class Sales implements Iterable<Order>{
    private ArrayList<Order> orders;

    public Sales(){
        this.orders = new ArrayList<Order>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public int getNoOrders(){
        return orders.size();
    }

    public int countOrdersWithProduct(String code){
        int count = 0;
        for (Order order : orders){
            if (order.getItem(code) != null){
                count++;
            }
        }
        return count;
    }

    public int totalQuantitySold(String code){
        int totalQuantity = 0;
        for (Order order : orders){
            OrderItem item = order.getItem(code);
            if (item != null){
                totalQuantity += item.getQuantity();
            }
        }
        return totalQuantity;
    }

    public java.util.Iterator<Order> iterator(){
        return orders.iterator();
    }
}
