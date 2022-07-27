package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYY):");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        sc.nextLine();
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = sc.nextLine();

        Order order = new Order(OrderStatus.valueOf(status));

        System.out.print("How many items to this order? ");
        int items = sc.nextInt();

        sc.nextLine();

        for (int i = 1; i <= items; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();
            Product product = new Product(nameProduct, priceProduct);
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            OrderItem item = new OrderItem(product.getName(),quantity, product.getPrice());
            order.addItem(item);
            sc.nextLine();
        }
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.print("Order moment: ");
        System.out.println(sdf2.format(order.getMoment()));
        System.out.print("Order Status: ");
        System.out.println(order.getStatus());
        System.out.print("Client: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail());
        System.out.println();
        System.out.println("Order items:");
        System.out.println(order.toString()); 
        System.out.print("Total price: ");
        System.out.println(order.total());

        sc.close();
    }
}