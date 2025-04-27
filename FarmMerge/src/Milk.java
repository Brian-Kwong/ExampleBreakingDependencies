import java.awt.*;
import java.util.Date;

public class Milk extends GameObjects{

    Date expirationDate;
    String milkType;

    public Milk(int id, Point position, int width, int height, String milkType) {
        super(id, position, width, height);
        expirationDate = new Date();
        expirationDate.setTime(expirationDate.getTime()*1000 + 604800000); // 7 days from now\
        this.milkType = milkType;
    }
}
