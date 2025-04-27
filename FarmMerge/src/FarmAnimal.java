import java.awt.*;
import java.util.Random;

public class FarmAnimal extends GameObjects implements Alive {

    int health;
    int hunger;
    int happiness;
    int age;
    int reproductionRate;

    public FarmAnimal(int id, Point position, int width, int height, int health, int hunger, int happiness, int age, int reproductionRate) {
        super(id, position, width, height);
        this.health = health;
        this.hunger = hunger;
        this.happiness = happiness;
        this.age = age;
        this.reproductionRate = reproductionRate;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void grow() {
        if (happiness > 0 && hunger < 10) {
            health += reproductionRate;
            happiness -= reproductionRate;
            hunger += reproductionRate;
        }
    }

    @Override
    public GameObjects collect() {
        if (health >= 200) {
            System.out.println("Farm Animal is ready for harvest!");
            age++;
            Random rand = new Random();
            Point new_pos = getPosition();
            new_pos.x = getPosition().x + 50;
            new_pos.y = getPosition().y + 50;
            if (age > 3) {
                return new Vegetable(rand.nextInt(), getPosition(), getWidth(), getHeight());
            } else {
                return new Coin(rand.nextInt(), new_pos, getWidth(), getHeight());
            }
        } else {
            System.out.println("Farm Animal is not ready for harvest yet.");
            return null;
        }
    }
}
