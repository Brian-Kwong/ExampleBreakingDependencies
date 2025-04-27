import java.awt.*;

public class Business extends Building{

    long revenue;
    int employees;
    int openingHour;
    int closingHour;
    int hoursOpenPerDay;
    String businessName;
    License license;
    boolean open;

    public Business(int id, Point position, int width, int height, int floors, String material, License license, long revenue, int employees, int openingHour, int closingHour, int hoursOpenPerDay, String businessName) {
        super(id, position, width, height, floors, material);
        this.license = license;
        this.revenue = revenue;
        this.employees = employees;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.hoursOpenPerDay = hoursOpenPerDay;
        this.businessName = businessName;
        this.open = false;
    }

    public void open(){
        if (license.validate()) {
            System.out.println("Business is open");
            open = true;
        } else {
            System.out.println("Cannot open the business, license is not valid");
            open = false;
        }
    }
}
