import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Building extends GameObjects{

    int yearBuilt;
    int floors;
    String material;


    public Building(int id, Point position, int width, int height, int floors, String material) {
        super(id, position, width, height);
        this.yearBuilt = new GregorianCalendar().get(Calendar.YEAR);
        this.floors = floors;
        this.material = material;
    }
}
