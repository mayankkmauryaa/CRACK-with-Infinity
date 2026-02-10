
import java.util.ArrayList;

class Product {
    private final int productId;
    private final String productName;
    private double price;
    private int quantity;

    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void addStock(int amount) {
        if (amount > 0) quantity += amount;
    }

    public boolean reduceStock(int amount) {
        if (amount > 0 && quantity >= amount) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    public double getValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=$%.2f, quantity=%d}", 
                productId, productName, price, quantity);
    }
}

public class Inventory {
    private final ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public Product findProduct(int productId) {
        return products.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    public boolean addStock(int productId, int amount) {
        Product product = findProduct(productId);
        if (product != null) {
            product.addStock(amount);
            return true;
        }
        return false;
    }

    public boolean sellProduct(int productId, int amount) {
        Product product = findProduct(productId);
        return product != null && product.reduceStock(amount);
    }

    public double calculateTotalValue() {
        return products.stream()
                .mapToDouble(Product::getValue)
                .sum();
    }

    public void displayInventory() {
        System.out.println("=== Current Inventory ===");
        products.forEach(System.out::println);
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        
        inventory.addProduct(new Product(1, "Laptop", 999.99, 10));
        inventory.addProduct(new Product(2, "Mouse", 29.99, 50));
        inventory.addProduct(new Product(3, "Keyboard", 79.99, 30));
        inventory.addProduct(new Product(4, "Monitor", 299.99, 15));
        inventory.addProduct(new Product(5, "Headphones", 49.99, 25));
        inventory.addProduct(new Product(6, "Webcam", 89.99, 20));
        inventory.addProduct(new Product(7, "USB Cable", 12.99, 100));

        System.out.printf("Initial inventory value: $%.2f%n", inventory.calculateTotalValue());
        inventory.displayInventory();

        inventory.addStock(1, 5);
        inventory.sellProduct(2, 10);
        inventory.sellProduct(7, 25);

        System.out.printf("Updated inventory value: $%.2f%n", inventory.calculateTotalValue());
        inventory.displayInventory();
    }
}