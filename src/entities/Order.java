package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment = new Date();
    private OrderStatus status;
    private final List<OrderItem> items = new ArrayList<>();

    public Order(OrderStatus status) {
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double total = 0.0;
        for (OrderItem orderItem : items) {
            total += orderItem.subTotal();
        }
        return total;
    }

    Product product = new Product();
    OrderItem item = new OrderItem();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (OrderItem orderItem : items) {
            sb.append(product.getName() + ", ");
            sb.append(Product.getPrice());
            sb.append(", Quantity: ");
            sb.append(orderItem.getQuantity());
            sb.append(", Subtotal: " + orderItem.subTotal() + "\n");
        }
        String str = sb.toString();
        return str;
    }


}
