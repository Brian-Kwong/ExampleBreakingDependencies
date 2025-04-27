import java.awt.*;
import java.util.Random;

public class Carrot extends Plants{

    public Carrot(int id, Point position, int width, int height) {
        super(id, position, width, height, "Carrot", 10, 2, 5, 3, 7);
    }

    @Override
    public void grow() {
        if (getWaterLevel() > 6 && getSunlightLevel() > 2  && getNutrientLevel() > 1) {
            health += getGrowthRate() * 2;
            waterLevel += getWaterLevel() - 5;
            sunlightLevel += getSunlightLevel() - 2;
            nutrientLevel += getNutrientLevel() - 2;
        }
    }

    @Override
    public GameObjects collect(){
        if (health >= 60) {
            System.out.println("Plant is ready for harvest!");
            age++;
            Random rand = new Random();
            Point new_pos = getPosition();
            new_pos.x = getPosition().x +50;
            new_pos.y = getPosition().y +50;
            if(age > 3) {
                return new MiniCarrot(rand.nextInt(), new_pos, getWidth(), getHeight(), 5, Color.ORANGE);
            }
            else{
                return new Coin(rand.nextInt(), new_pos, getWidth(), getHeight());
            }
        } else {
            System.out.println("Plant is not ready for harvest yet.");
            return null;
        }
    }
}
