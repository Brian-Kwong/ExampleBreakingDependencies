import java.awt.*;
import java.util.Random;

public class Wheat extends Plants{

    public Wheat(int id, Point position, int width, int height, String type, int health, int growthRate, int sunlightLevel, int nutrientLevel, int harvestTime) {
        super(id, position, width, height, type, health, growthRate, sunlightLevel, nutrientLevel, harvestTime);
    }

    @Override
    public GameObjects collect(){
        if (health >= 120) {
            System.out.println("Wheat is ready for harvest!");
            age++;
            Random rand = new Random();
            Point new_pos = getPosition();
            new_pos.x = getPosition().x + 50;
            new_pos.y = getPosition().y + 50;
            if (age > 3) {
                return new Grain(rand.nextInt(), getPosition(), getWidth(), getHeight());
            } else {
                return new Coin(rand.nextInt(), new_pos, getWidth(), getHeight());
            }
        } else {
            System.out.println("Wheat is not ready for harvest yet.");
            return null;
        }
    }
}
