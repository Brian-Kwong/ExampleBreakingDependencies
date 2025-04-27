import java.awt.*;

public class Coin extends GameObjects{

    int value;
    String material;

    public void createCoinValue(int value){
        this.value = value;
        switch (value) {
            case 3,9:
                this.material = "Copper";
                break;
            case 27,81:
                this.material = "Silver";
                break;
            case 243,729:
                this.material = "Gold";
                break;
            default:
                this.material = "Unknown";
        }
    }

    public Coin(int id, Point position, int width, int height, int value) {
        super(id, position, width, height);
        createCoinValue(value);
    }

    public Coin(int id, Point position, int width, int height){
        super(id, position, width, height);
        createCoinValue(3);
    }
}
