import java.awt.*;
import java.util.Date;

public class Bacon  extends AnimalProducts{

    String baconType;
    float weight;

    public Bacon(int id, Point position, int width, int height, float weight, String baconType) {
        super(id, position, width, height);
        expirationDate = new Date();
        expirationDate.setTime(expirationDate.getTime()*1000 + 432000000); // 5 days from now
        this.weight = weight;
        this.baconType = baconType;
    }

}
