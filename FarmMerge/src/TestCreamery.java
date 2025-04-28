import java.awt.*;

public class TestCreamery extends  Creamery{
    public TestCreamery(int id, Point position, int width, int height, int floors, String material, License bussinessLicense, long revenue, int employees, int openingHour, int closingHour, int hoursOpenPerDay, String businessName, String specialty, DairyLicense dl) {
        super(id, position, width, height, floors, material, bussinessLicense, revenue, employees, openingHour, closingHour, hoursOpenPerDay, businessName, specialty, dl);
    }

    @Override
    public  void open(){
        this.open = true;
    }
}
