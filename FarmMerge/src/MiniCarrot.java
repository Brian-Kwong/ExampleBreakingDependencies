import java.awt.*;

public class MiniCarrot
extends Vegetable {

    int length;
    Color color;

    public MiniCarrot(int id, Point position, int width, int height, int length, Color color) {
        super(id, position, width, height);
        this.length = length;
        this.color = color;
    }
}
