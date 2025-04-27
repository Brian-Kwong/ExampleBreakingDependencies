import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Creamery extends Business {

    String specialty;
    DairyLicense dairyLicense;

    public Creamery(int id, Point position, int width, int height, int floors, String material, License bussinessLicense, long revenue, int employees, int openingHour, int closingHour, int hoursOpenPerDay, String businessName, String specialty, DairyLicense dl) {
        super(id, position, width, height, floors, material, bussinessLicense, revenue, employees, openingHour, closingHour, hoursOpenPerDay, businessName);
        this.specialty = specialty;
        this.dairyLicense = dl;
    }

    @Override
    public void open() {
        try {
            if (license.validate() && dairyLicense.validate() && dairyLicense.hasValidCDFACertification()) {
                open = true;
            } else {
                System.out.println("Cannot open the creamery, license is not valid");
                open = false;
            }
        }
        catch (IOException | InterruptedException e) {
            System.out.println("Error validating CDFACertification: " + e.getMessage());
            open = false;
        }
    }

    public Product produce(String flavor){
        if(open){
            Random rand = new Random();
            return new Yougart(
                    "Creamery Yougart",
                    2.99F,
                    10,
                    "Amazing Yougart",
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24),
                    flavor, 16);
        }
        else{
            System.out.println("Creamery is closed");
            return null;
        }
    }

    public void sell(Product product){
        if(open){
            Random rand = new Random();
            DataRepository.getInstance().getUser().updateBalance(
                    new Coin(rand.nextInt(),
                            new Point(rand.nextInt(), rand.nextInt()),
                            10,10, (int) product.price)
            );
        }
        else{
            System.out.println("Creamery is closed");
        }
    }
}

