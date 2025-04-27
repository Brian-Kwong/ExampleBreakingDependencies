import java.awt.*;
import java.util.Date;

public class Eggs extends GameObjects{

    Color color;
    Date expirationDate;

    public Eggs(int id, Point position, int width, int height, Color color) {
        super(id, position, width, height);
        this.color = color;
        this.expirationDate = new Date();

    }
}
