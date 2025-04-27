import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        DataRepository db = DataRepository.getInstance();
        db.connectToDatabase(
                "user1",
                "helloworld");
       BussinessPermit bp = new BussinessPermit(
                dateParser.parse("2023-01-01"),
                dateParser.parse("2029-01-01"),
                "123456789",
                "Bussiness Permit for Creamery",
                "My Amazing Creamery",
               12345,
               "Farm Merge Inc",
               true,
                "123 Main St",
                "San Luis Obispo",
                "CA",
                "");
        DairyLicense dl = new DairyLicense(
                dateParser.parse("2023-01-01"),
                dateParser.parse("2029-01-01"),
                "123456789",
                "Dairy License for Creamery",
                "CloverLeaf Animal Welfare Systems",
                dateParser.parse("2023-01-01"),
                'A',
                "No restrictions");
        Creamery creamery = new Creamery(
                1,
                new Point(10, 20),
                100,
                200,
                2,
                "Brick",
                bp,
                1000000,
                10,
                8,
                18,
                10,
                "Creamery",
                "Ice Cream",
                dl);
        creamery.open();
        Product product = creamery.produce("Vanilla");
       System.out.println(product.consume());
    }
}