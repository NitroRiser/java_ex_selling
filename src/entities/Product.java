package entities;

public class Product {
    private String name;
    private static Double price;

    public Product() {

    }

    public Product(String name, Double price) {
        this.name = name;
        Product.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        Product.price = price;
    }

}
