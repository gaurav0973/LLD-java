/*
Scenario: A Search feature in UniTrade.
You might want to search by product name OR by price range.
*/
class ProductSearch {
    public void search(String productName) {
        System.out.println("Searching for: " + productName);
    }
    public void search(double minPrice, double maxPrice) {
        System.out.println("Searching products between $" + minPrice + " and $" + maxPrice);
    }
    public void search(String productName, double maxPrice) {
        System.out.println("Searching " + productName + " under $" + maxPrice);
    }
}

public class Overloading {
    public static void main(String[] args) {
        ProductSearch ps = new ProductSearch();
        ps.search("Laptop");
        ps.search(500.0, 1500.0);
        ps.search("Smartphone", 800.0);
    }
}
