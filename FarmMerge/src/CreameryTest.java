import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;

public class CreameryTest {
    @Test
    void createYougart() throws IOException, InterruptedException, ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        DataRepository db = DataRepository.getInstance();
        db.connectToDatabase(
                "user1",
                "helloworld");
        BusinessPermit bp = new BusinessPermit(
                dateParser.parse("2023-01-01"),
                dateParser.parse("2029-01-01"),
                "123456789",
                "Business Permit for Creamery",
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
        assertEquals( Yougart.class,product.getClass());
    }

    @Test
    void consumeYougart() throws IOException, InterruptedException, ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        DataRepository db = DataRepository.getInstance();
        db.connectToDatabase(
                "user1",
                "helloworld");
        BusinessPermit bp = new BusinessPermit(
                dateParser.parse("2023-01-01"),
                dateParser.parse("2029-01-01"),
                "123456789",
                "Business Permit for Creamery",
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
        MatcherAssert.assertThat(product.consume(), allOf(
                containsString("yougart"),
                containsString("Vanilla"),
                containsString("consumed")
        ));
    }

    @Test
    void sellYougart() throws IOException, InterruptedException, ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        DataRepository db = DataRepository.getInstance();
        db.connectToDatabase(
                "user1",
                "helloworld");
        BusinessPermit bp = new BusinessPermit(
                dateParser.parse("2023-01-01"),
                dateParser.parse("2029-01-01"),
                "123456789",
                "Business Permit for Creamery",
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
        creamery.sell(product);
        assertEquals(3,db.getUser().balance);
    }
}
