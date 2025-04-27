import java.awt.*;
import java.util.Random;

public class Plants extends GameObjects implements Alive {
    String type;
    int age;
    int waterLevel;
    int health;
    int growthRate;
    int sunlightLevel;
    int nutrientLevel;
    int harvestTime;

    public Plants(int id, Point position, int width, int height, String type, int health
            , int growthRate, int sunlightLevel, int nutrientLevel, int harvestTime){
        super(id, position, width, height);
        this.type = type;
        this.health = health;
        this.growthRate = growthRate;
        this.sunlightLevel = sunlightLevel;
        this.nutrientLevel = nutrientLevel;
        this.harvestTime = harvestTime;
        this.waterLevel = 0;
        this.age = 0;
    }

    public String getType() {
        return type;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getHealth() {
        return health;
    }

    public int getGrowthRate() {
        return growthRate;
    }

    public int getSunlightLevel() {
        return sunlightLevel;
    }

    public int getNutrientLevel() {
        return nutrientLevel;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public void water(int amount) {
        waterLevel += amount;
    }

    public void grow(){
        if (waterLevel > 0 && sunlightLevel > 0 && nutrientLevel > 0) {
            health += growthRate;
            waterLevel--;
            sunlightLevel--;
            nutrientLevel--;
        }
    }

    public GameObjects collect(){
        if (health >= 100) {
            System.out.println("Plant is ready for harvest!");
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
            System.out.println("Plant is not ready for harvest yet.");
            return null;
        }
    }

}
