import java.awt.*;
import java.util.Random;

public class Chicken extends FarmAnimal {

    int eggCapacity;
    int eggProductionRate;
    Color eggType;
    float eggWeight;
    float weight;
    Color color;

    public Chicken(int id, Point position, int width, int height, int health, int hunger, int happiness, int age, int reproductionRate, int eggCapacity, int eggProductionRate, Color eggType, float eggWeight, float weight, Color color) {
        super(id, position, width, height, health, hunger, happiness, age, reproductionRate);
        this.eggCapacity = eggCapacity;
        this.eggProductionRate = eggProductionRate;
        this.eggType = eggType;
        this.eggWeight = eggWeight;
        this.weight = weight;
        this.color = color;
    }

    public Chicken(int id, Point position, int width, int height, int health, int hunger, int happiness, int age, int reproductionRate) {
        super(id, position, width, height, health, hunger, happiness, age, reproductionRate);
        this.eggCapacity = 2;
        this.eggProductionRate = 2;
        this.eggType = Color.YELLOW;
        this.eggWeight = 0.5f;
        this.weight = 2.0f;
        this.color = Color.WHITE;
    }

    @Override
    public void grow() {
        if (happiness > 5 && hunger < 15) {
            health += reproductionRate;
            happiness -= reproductionRate;
            hunger += reproductionRate;
            eggCapacity += eggProductionRate;
        }
    }

    @Override
    public GameObjects collect() {
        if (eggCapacity > 12) {
            System.out.println("Chicken eggs are ready to be collected!");
            age++;
            Random rand = new Random();
            Point new_pos = getPosition();
            new_pos.x = getPosition().x + 50;
            new_pos.y = getPosition().y + 50;
            if (age > 3) {
                return new Eggs(rand.nextInt(), getPosition(), getWidth(), getHeight(), eggType);
            } else {
                return new Coin(rand.nextInt(), new_pos, getWidth(), getHeight());
            }
        } else {
            System.out.println("Chicken is not ready for egg collection yet.");
            return null;
        }
    }
}
