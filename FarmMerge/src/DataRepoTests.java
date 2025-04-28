import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataRepoTests {
    @Test
    void createRepo() {
        DataRepository db = DataRepository.getInstance();
        assertEquals(DataRepository.class,db.getClass());
    }

    @Test
    void countCattle() throws IOException, InterruptedException {
        TestDataRepo db = new TestDataRepo();
    db.connectToDatabase(new Player());
    db.getBoard(
        """
{
    "board": [
        {
            "age": 1,
            "color": [
                255,
                255,
                255
            ],
            "cowType": "Jersey",
            "happiness": 5,
            "health": 100,
            "height": 20,
            "hunger": 5,
            "id": 1,
            "milkCapacity": 100,
            "milkProductionRate": 10,
            "position": [
                0,
                0
            ],
            "reproductionRate": 1,
            "type": "Cow",
            "weight": 100.0,
            "width": 20
        },
        {
            "age": 3,
            "baconProductionRate": 10,
            "baconWeight": 25,
            "color": [
                255,
                255,
                255
            ],
            "happiness": 5,
            "health": 50,
            "height": 20,
            "hunger": 5,
            "id": 24,
            "position": [
                300,
                400
            ],
            "reproductionRate": 10,
            "type": "Pig",
            "weight": 100.0,
            "width": 20
        },
        {
            "age": 0,
            "growthRate": 5,
            "harvestTime": 10,
            "health": 30,
            "height": 20,
            "id": 77,
            "nutrientLevel": 5,
            "position": [
                430,
                60
            ],
            "sunlightLevel": 5,
            "type": "Corn",
            "waterLevel": 5,
            "width": 20
        }
    ],
    "id": "user1"
}
""");
        assertEquals(2,db.countNumberOfCastles());
    }
}
