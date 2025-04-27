import java.awt.*;
import java.util.Date;

public class AnimalProducts extends GameObjects{

    Date expirationDate;

    public AnimalProducts(int id, Point position, int width, int height) {
        super(id, position, width, height);
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public boolean isExpired() {
        Date currentDate = new Date();
        return expirationDate.before(currentDate);
    }
}
