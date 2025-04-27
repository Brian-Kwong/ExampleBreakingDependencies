import java.awt.*;

public class GameObjects {
    private final int id;
    private Point position;
    private final int width;
    private final int height;

    public GameObjects(int id, Point position, int width, int height) {
        this.id = id;
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }
    public Point getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public String toString() {
        return "GameObjects{" +
                "\n\tid=" + id +
                "\n\t position=" + position +
                "\n\t width=" + width +
                "\n\t height=" + height +
                "\n}";
    }
}
