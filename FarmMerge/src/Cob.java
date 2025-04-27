import java.awt.*;

public class Cob extends Vegetable {

    int length;
    String cornType;

    public Cob(int id, Point position, int width, int height, int length, String cornType) {
        super(id, position, width, height);
        this.length = length;
        this.cornType = cornType;
    }
}
