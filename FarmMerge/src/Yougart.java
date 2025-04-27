import java.util.Date;

public class Yougart extends Product {

    String flavor;
    int size;

    public Yougart(String name, float price, int sku, String description, Date expirationDate, String flavor, int size) {
        super(name, price, sku, description, expirationDate);
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String consume() {
        if (isExpired()) {
            return "Yougart is expired and cannot be consumed.";
        } else {
            return "Yummy! " + size + " oz "  + flavor + " yougart consumed successfully.";
        }
    }
}
