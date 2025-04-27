import java.awt.*;
import java.util.Random;

public class Pig extends FarmAnimal{

    Color color;
    int weight;
    int baconProductionRate;
    int baconWeight;

    /*
    Default constructor for Pig class
     */
    public Pig(int id, Point position, int width, int height, int health, int hunger, int happiness, int age, int reproductionRate) {
        super(id, position, width, height, health, hunger, happiness, age, reproductionRate);
        this.color = Color.PINK;
        this.weight = 100;
        this.baconProductionRate = 10;
        this.baconWeight = 10;
    }

    public Pig(int id, Point position, int width, int height, int health, int hunger, int happiness, int age, int reproductionRate, Color color, int weight, int baconProductionRate, int baconWeight) {
        super(id, position, width, height, health, hunger, happiness, age, reproductionRate);
        this.color = color;
        this.weight = weight;
        this.baconProductionRate =  baconProductionRate;
        this.baconWeight = baconWeight;
    }

    @Override
    public void grow() {
        if (happiness > 8 && hunger < 10) {
            health += reproductionRate;
            happiness -= reproductionRate;
            hunger += reproductionRate;
            if(weight > 70){
                baconWeight += baconProductionRate;
            }
            else{
                weight += baconProductionRate;
            }
        }
    }

    @Override
    public GameObjects collect() {
        if (baconWeight >= 50) {
            System.out.println("Pig is ready for harvest!");
            age++;
            Random rand = new Random();
            Point new_pos = getPosition();
            new_pos.x = getPosition().x + 50;
            new_pos.y = getPosition().y + 50;
            if (age > 3) {
                return new Bacon(rand.nextInt(), getPosition(), getWidth(), getHeight(), baconWeight, "Pork");
            } else {
                return new Coin(rand.nextInt(), new_pos, getWidth(), getHeight());
            }
        } else {
            System.out.println("Pig is not ready for harvest yet.");
            return null;
        }
    }
}
