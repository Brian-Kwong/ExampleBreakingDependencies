import java.awt.*;
import java.util.Random;

public class Corn extends Plants{

    public Corn(int id, Point position, int width, int height) {
        super(id, position, width, height, "Corn", 15, 3, 6, 4, 8);
    }

    @Override
    public void grow() {
        if (getWaterLevel() > 5 && getSunlightLevel() > 3 && getNutrientLevel() > 7) {
            health += getGrowthRate() *2;
            waterLevel += getWaterLevel() - 5;
            sunlightLevel += getSunlightLevel() - 3;
            nutrientLevel += getNutrientLevel() - 7;
        }
    }

    @Override
    public GameObjects collect(){
        if (health >= 70) {
            System.out.println("Corn is ready for harvest!");
            age++;
            Random rand = new Random();
            Point new_pos = getPosition();
            new_pos.x = getPosition().x +50;
            new_pos.y = getPosition().y +50;
            if(age > 4) {
                return new Cob(rand.nextInt(), new_pos, getWidth(), getHeight(), 6, "Sweet Corn");
            }
            else{
                return new Coin(rand.nextInt(), new_pos, getWidth(), getHeight());
            }
        } else {
            System.out.println("Corn is not ready for harvest yet.");
            return null;
        }
    }
}
