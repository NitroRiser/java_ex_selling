package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private String name;


    public OrderItem(){

    }

    public OrderItem(String name, Integer quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public Double subTotal(){
        return price * quantity;
    }    
    
}