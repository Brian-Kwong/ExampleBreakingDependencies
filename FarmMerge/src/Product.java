import java.util.Date;
import java.util.UUID;

public class Product {
    String name;
    String description;
    UUID id;
    int sku;
    float price;
    Date expirationDate;

    public Product(String name, float price,int sku, String description, Date expirationDate) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.id = UUID.randomUUID();
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public int getSku() {
        return sku;
    }

    public float getPrice() {
        return price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public boolean isExpired() {
        Date currentDate = new Date();
        return expirationDate.before(currentDate);
    }

    public String consume() {
        if (isExpired()) {
            return "Product is expired and cannot be consumed.";
        } else {
            return "Nicee! Product consumed successfully.";
        }
    }

}
