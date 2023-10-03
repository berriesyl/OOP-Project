package healme_products;

/* CreditCard class represents a credit card in the Healmeproducts system.
   It contains information about the credit card such as card number, owner, security code, and expiration date. */
public class CreditCard {
    private User customer;
    private String creditCardNo;
    private int securityCode;
    private String expirationDate;

    // Constructor to initialize a CreditCard object with the given parameters.
    public CreditCard(String creditCardNo, User customer, int securityCode, String expirationDate) {
        this.creditCardNo = creditCardNo;
        this.customer = customer;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
    }

    // Method to write the credit card information.
    public void writeCreditCardInfo() {
        System.out.println("----------------------------");
        System.out.println("Owner of Credit Card: " + customer.getName());
        System.out.println("Credit Card No: " + creditCardNo);
        System.out.println("Security Code: " + securityCode);
        System.out.println("Expiration Date of Credit Card: " + expirationDate);
        System.out.println("----------------------------");
    }

    // Getters and setters for the CreditCard class properties.
    public String getCreditCardNo() {
        return creditCardNo;
    }

    public User getCustomer() {
        return customer;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
