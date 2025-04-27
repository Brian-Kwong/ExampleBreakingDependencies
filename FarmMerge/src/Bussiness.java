import java.awt.*;

public class Bussiness extends Building{

    long revenue;
    int employees;
    int openingHour;
    int closingHour;
    int hoursOpenPerDay;
    String bussinessName;
    License license;
    boolean open;

    public Bussiness(int id, Point position, int width, int height, int floors, String material, License license, long revenue, int employees, int openingHour, int closingHour, int hoursOpenPerDay, String bussinessName) {
        super(id, position, width, height, floors, material);
        this.license = license;
        this.revenue = revenue;
        this.employees = employees;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.hoursOpenPerDay = hoursOpenPerDay;
        this.bussinessName = bussinessName;
        this.open = false;
    }

    public void open(){
        if (license.validate()) {
            System.out.println("Bussiness is open");
            open = true;
        } else {
            System.out.println("Cannot open the bussiness, license is not valid");
            open = false;
        }
    }
}
