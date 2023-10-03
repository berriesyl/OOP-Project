package healme_products;

import java.util.ArrayList;

/* The Order class represents an order in the Healme_Products system.
   It contains information about the customer, the products being ordered, and the credit card used for payment. */
public class Order {
    private User customer;
    public ArrayList<Product> products;
    private String creditCard;

    // Constructor to initialize an Order object with the given parameters.
    public Order(User customer, ArrayList<Product> products, String creditCard) {
        this.customer = customer;
        this.products = products;
        this.creditCard = creditCard;
    }
    // Getters and setters for the Order class properties.
    public User getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
