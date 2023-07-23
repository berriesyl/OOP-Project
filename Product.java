package healme_products;

import java.util.ArrayList;

/* Product class represents a product in the Healmeproducts system.
   It contains information about the product such as name, color, category, description, stock, and weight. */
public class Product {
    private String productName;
    private String productColour;
    private String productCategory;
    private String descriptionInfo;
    private int stockInfo;
    private double weight;
    

    // Constructor to initialize a Product object with the given parameters.
    public Product(String productName, String productColour, String productCategory, String descriptionInfo, int stockInfo, double weight) {
        this.productName = productName;
        this.productColour = productColour;
        this.productCategory = productCategory;
        this.descriptionInfo = descriptionInfo;
        this.stockInfo = stockInfo;
        this.weight = weight;
    }

    // Method to check the availability of the product.
    // Returns true if the stock count is greater than 0, indicating that the product is available.
    public boolean checkAvailability() {
        return stockInfo > 0;
    }

    // Method to write the information of the product.
    public void writeProductInfo() {
        System.out.println("----------------------------");
        System.out.println("Product Selected: " + productName + " - " + productCategory + " - " + productColour + " - " + stockInfo);
        System.out.println("Description Info.: " + descriptionInfo);
        System.out.println("----------------------------");
    }
    

    // Getters and setters for the Product class properties.
    public String getProductName() {
        return productName;
    }

    public String getProductColour() {
        return productColour;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getDescriptionInfo() {
        return descriptionInfo;
    }

    public int getStockInfo() {
        return stockInfo;
    }

    public double getWeight() {
        return weight;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setDescriptionInfo(String descriptionInfo) {
        this.descriptionInfo = descriptionInfo;
    }

    public void setStockInfo(int stockInfo) {
        this.stockInfo = stockInfo;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Method to decrease the stock quantity of the product by 1.
    public void decreaseStockQuantity() {
        if (stockInfo > 0) {
            stockInfo--;
        }
    }

    // Method to get the stock quantity of the product.
    public int getStockQuantity() {
        return stockInfo;
    }
}
