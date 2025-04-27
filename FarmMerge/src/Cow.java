import java.awt.*;
import java.util.Random;

public class Cow extends FarmAnimal{

    String cowType;
    Color color;
    float weight;
    int milkProductionRate;
    int milkCapacity;

    public Cow(int id, Point position, int width, int height) {
        super(id, position, width, height, 10, 0, 5, 0, 1);
        this.cowType = "Dairy";
        this.color = Color.WHITE;
        this.weight = 500.0f;
        this.milkProductionRate = 10;
        this.milkCapacity = 100;
    }

    public Cow(int id, Point position, int width, int height, int health, int hunger, int happiness, int age, int reproductionRate, String cowType, Color color, float weight, int milkProductionRate, int milkCapacity) {
        super(id, position, width, height, health, hunger, happiness, age, reproductionRate);
        this.cowType = cowType;
        this.color = color;
        this.weight = weight;
        this.milkProductionRate = milkProductionRate;
        this.milkCapacity = milkCapacity;
    }

    @Override
    public void grow() {
        if (happiness > 0 && hunger < 10) {
            health += reproductionRate;
            happiness -= reproductionRate;
            hunger += reproductionRate;
            milkCapacity += reproductionRate;
        }
    }

    @Override
    public GameObjects collect() {
        if (milkCapacity >= 100) {
            System.out.println("Cow is ready for milking");
            age++;
            Random rand = new Random();
            Point new_pos = getPosition();
            new_pos.x = getPosition().x + 50;
            new_pos.y = getPosition().y + 50;
            if (age > 3) {
                return new Milk(rand.nextInt(), new_pos, getWidth(), getHeight(), "Whole Milk");
            } else {
                return new Coin(rand.nextInt(), new_pos, getWidth(), getHeight());
            }
        } else {
            System.out.println("Cow is not ready for milking.");
            return null;
        }
    }
}
