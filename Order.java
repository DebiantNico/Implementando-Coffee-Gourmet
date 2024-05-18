public class Order {

    private OrderItem[] items;
    private int indice;

    public Order() {
        indice = 0;
        items = new OrderItem[3];
    }

    public void addOrderItem(OrderItem item) {
        if (indice == items.length) {
            OrderItem[] tmp = new OrderItem[items.length + 1];
            for (int i = 0; i < indice; i++) {
                tmp[i] = items[i];
            }
            items = tmp;
        }
        items[indice] = item;   
        indice = indice + 1;
    }

    public void removeOrderItem(OrderItem item) {
        boolean found = false;
        for (int i = 0; i < indice; i++) {
            if (items[i].equals(item)) {
                found = true;
                items[i] = null;
                break;
            }
        }
        if (found) {
            OrderItem[] tmp = new OrderItem[indice - 1];
            int j = 0;
            for (int i = 0; i < indice; i++) {
                if (items[i] != null) {
                    tmp[j] = items[i];
                    j++;
                }
            }
            items = tmp;
            indice--;
        }
    }

    public int getNoItems() {
        return indice;
    }

    public OrderItem getItem(int pos) {
        if (pos < indice) {
            return items[pos];
        }
        return null;
    }

    public OrderItem getItem(String code) {
        for (OrderItem item : items) {
            if (item != null && item.getProduct().getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (OrderItem item : items) {
            if (item != null) {
                totalCost += item.getValue();
            }
        }
        return totalCost;
    }

    public boolean containsProduct(String code) {
        return getItem(code) != null;
    }

    public int quantityOfProduct(String code) {
        OrderItem item = getItem(code);
        if (item != null) {
            return item.getQuantity();
        }
        return 0;
    }
}
