package healme_products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* The User class represents a user in the Healme_Products system.
   It contains information about the user, such as username, name,
surname, date of birth, email, addresses, and related lists. */
public class User {

    private String username;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private StringBuilder password;
    private String email;
    private String homeAddress;
    private String workAddress;
    private ArrayList<Product> selectedProducts;
    private ArrayList<Order> productsOrdered;
    private ArrayList<Product> favoriteProducts;
    private ArrayList<CreditCard> creditCards;

    // Constructor to initialize a User object with the given parameters.
    public User(String username, String name, String surname, LocalDate dateOfBirth, String email, String homeAddress, 
            String workAddress,StringBuilder password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.email = email;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.selectedProducts = new ArrayList<Product>();
        this.creditCards = new ArrayList<CreditCard>();
        this.favoriteProducts = new ArrayList<Product>();
        this.productsOrdered = new ArrayList<Order>();
    }

    // Method to add a credit card to the user's list of credit cards.
    // Returns true if the credit card is added successfully, false if it is already added.
    public boolean addCreditCard(CreditCard creditCard) {
        if (creditCards.contains(creditCard)) {
            System.out.println(">>>This credit card is already added.<<<");
            return false;
        } else {
            creditCards.add(creditCard);
            System.out.println(">>>Credit card added successfully!<<<");
            return true;
        }
    }

    // Method to add products to the user's list of favorite products.
    public void addMyFavorites(ArrayList<Product> products) {
        this.favoriteProducts.addAll(products);
        System.out.println("The selected products have been added to *My Favorites*");
    }

    // Method to create an order for the user with the given products and credit card.
    // Checks if the credit card is valid and if the products are available in stock.
    // If the order is created successfully, adds the products to the user's list of ordered products and decreases the stock count.
    public void createOrder(ArrayList<Product> products, CreditCard creditCard) {
       
        boolean allProductsAvailable = true;
        for (Product product : products) {
            if (!product.checkAvailability()) {
                allProductsAvailable = false;
                break;
            }
        }

        if (allProductsAvailable) {
        if (creditCards.contains(creditCard)) {
            // Create the order
            Order order = new Order(this, this.selectedProducts, creditCard.getCreditCardNo());

            // Add the products to the order
            for (int i = 0; i < products.size(); i++) {
                order.products.add(products.get(i));
            }

            this.productsOrdered.add(order);

            // Decrease the stock count for each product
            for (Product product : this.selectedProducts) {
                product.setStockInfo(product.getStockInfo() - 1);
            }

            System.out.println(">>>Order created successfully!<<<\nThank you for choosing us. We wish you healthy days!");

        } else {
            System.out.println(">>>Invalid credit card number!<<<");
        } }
       
        else {
            System.out.println("One of the products is out of stock!");
        
    }

    }

    // Method to display the user's information and related lists.
    public void writeAtt(User user) {
        System.out.println("----------------------------");
        System.out.println("User Information:");
        System.out.println("Username: " + this.getUsername());
        System.out.println("Name: " + this.getName());
        System.out.println("Surname: " + this.getSurname());
        System.out.println("Date of Birth: " + this.getDateOfBirth());
        System.out.println("Password: " + this.maskedPassword(password));
        System.out.println("Email: " + this.getEmail());
        System.out.println("Home Address: " + this.getHomeAddress());
        System.out.println("Work Address: " + this.getWorkAddress());
        System.out.println();

        System.out.println("Products Ordered:");
        if(!this.productsOrdered.isEmpty())
        for (Product product : productsOrdered.get(0).products) {
            System.out.println(product.getProductName());
        }
        else {
            System.out.println("**Order is not found!**");
        }
        System.out.println();

        System.out.println("My Favorite Products:");
        for (Product product : user.favoriteProducts) {
            System.out.println(product.getProductName());
        }

        System.out.println();

        System.out.println("Credit Cards Recorded:");
        for (CreditCard card : user.creditCards) {
            System.out.println(card.getCreditCardNo());
        }
    }

    // Method to mask the user's password by replacing characters with '*'.
    // Returns the masked password as a StringBuilder object.
    public StringBuilder maskedPassword(StringBuilder password) {
        StringBuilder maskedPassword = new StringBuilder(password);
        for (int i = 1; i < maskedPassword.length() - 1; i++) {
            maskedPassword.setCharAt(i, '*');
        }
        return maskedPassword;
    }

    // Getters and setters for the User class properties.
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public StringBuilder getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassword(StringBuilder password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public ArrayList<Order> getProductsOrdered() {
        return productsOrdered;
    }

    public ArrayList<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }
}
