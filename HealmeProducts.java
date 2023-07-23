
package healme_products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HealmeProducts {

    public static void main(String[] args) {
        System.out.println("*** Healme offers the key to wellness. Revitalize your body and mind with our organic healers.*** ");
        ArrayList<User> users = new ArrayList<>();

        // Created product objects
        Product p1 = new Product("Lidocaine", "white", "medicine", "have not updated yet", 100, 50);
        Product p2 = new Product("Lidocaine-2", "green", "medicine", "have not updated yet", 100, 50);
        Product p3 = new Product("OZONIOT", "colorless", "supplement", "have not updated yet", 0, 10);

        // User objects
        LocalDate dateOfBirth = LocalDate.of(2001, 05, 17);
        LocalDate dateOfBirth2 = LocalDate.of(1996, 02, 12);
        StringBuilder password = new StringBuilder("123456");
        StringBuilder password2 = new StringBuilder("12347");

        User u1 = new User("ebs", "berra", "söyler", dateOfBirth, "berra@ogr.tr", "İzmir", "İstanbul", password);
        User u2 = new User("tks", "tuna", "söyler", dateOfBirth2, "tuna@mail.com", "İzmir", "America",
                password2);

        // Credit card objects
        CreditCard c1 = new CreditCard("5124", u1, 302, "12/24");
        CreditCard c2 = new CreditCard("5121", u2, 103, "10/30");

        // Add c1 credit card to u1
        u1.addCreditCard(c1);

        // Create an order for u1 with c1 credit card and p2 product
        ArrayList<Product> order1 = new ArrayList<>();
        order1.add(p2);
        u1.createOrder(order1, c1);

        // Add p1 product to favorites list of u1
        ArrayList<Product> favorites1 = new ArrayList<>();
        favorites1.add(p1);
        u1.addMyFavorites(favorites1);

        // Add u1 to users list
        users.add(u1);

        // Add c2 credit card to u2
        u2.addCreditCard(c2);

        // Create an order for u2 with c2 credit card and p1 product
        ArrayList<Product> order2 = new ArrayList<>();
        order2.add(p3);
        u2.createOrder(order2, c2);

        // Add p2 product to favorites list of u2
        ArrayList<Product> favorites2 = new ArrayList<>();
        favorites2.add(p2);
        u2.addMyFavorites(favorites2);

        // Add u2 to users list
        users.add(u2);

        // Print all attributes of u1
        u1.writeAtt(u1);
        p2.writeProductInfo();
        c1.writeCreditCardInfo();

        // Print all attributes of u2
        u2.writeAtt(u2);
        p1.writeProductInfo();
        c2.writeCreditCardInfo();

        // Prompt the user to create an account
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nickname: ");
        String username = scanner.next();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Surname: ");
        String surname = scanner.next();
        System.out.print("Date of Birth (yyyy-mm-dd): ");
        String dateOfBirthStr = scanner.next();
        LocalDate dateOfBirthNew = LocalDate.parse(dateOfBirthStr);
        System.out.print("E-mail: ");
        String email = scanner.next();
        System.out.print("Home Address: ");
        String homeAddress = scanner.next();
        System.out.print("Work Address: ");
        String workAddress = scanner.next();
        StringBuilder password3 = new StringBuilder("231234564");
        System.out.println(">>>Password has been created! " + password3 + " is your password.<<<");

        System.out.print("Credit Card No: ");
        String creditCardNo3 = scanner.next();
        System.out.print("Security Code: ");
        String securityCodeStr = scanner.next();
        int securityCode = Integer.parseInt(securityCodeStr);
        System.out.print("Expiration Date of Credit Card: ");
        String expirationDate = scanner.next();

        // Create a user object with the created account
        User u3 = new User(username, name, surname, dateOfBirthNew, email, homeAddress, workAddress, password3);

        // Add the created account to users list
        users.add(u3);

        // Create a credit card object for the created user
        CreditCard c3 = new CreditCard(creditCardNo3, u3, securityCode, expirationDate);
        System.out.println(">>>User has been created! --->  @" + u3.getUsername());
        System.out.println("------------------------------");

        System.out.println("Select products from the list: ");
        System.out.println("1. " + p1.getProductName());
        System.out.println("2. " + p2.getProductName());
        System.out.println("3. " + p3.getProductName());

        ArrayList<Product> selectedProducts = new ArrayList<>();

        int selection;
        do {
            System.out.println("Enter the product selection between 1-3 (0 to finish):");
            selection = scanner.nextInt();

            if (selection > 0 && selection <= 3) {
                Product selectedProduct;
                switch (selection) {
                    case 1:
                        selectedProduct = p1;
                        break;
                    case 2:
                        selectedProduct = p2;
                        break;
                    default:
                        selectedProduct = p3;
                        break;
                }

                if (selectedProduct.getStockQuantity() > 0) {
                    selectedProducts.add(selectedProduct);
                    selectedProduct.decreaseStockQuantity();
                    System.out.println("Product added to the list.");
                } else {
                    System.out.println("This product is out of stock. Please select another product.");
                }
            } else if (selection != 0) {
                System.out.println("There is no product as you typed. Please type again between 1-3.");
            }
        } while (selection != 0);

        System.out.println("Selected products:");
        for (Product product : selectedProducts) {
            System.out.println(product.getProductName());
        }

        // Print all attributes of u3
        u3.addCreditCard(c3);
        u3.createOrder(selectedProducts, c3);
        u3.addMyFavorites(selectedProducts);
        u3.writeAtt(u3);

        c3.writeCreditCardInfo();

        // Show usernames of all users
        System.out.println("All users: ");
        for (User user : users) {
            System.out.println("@" + user.getUsername());
        }
    }
}
