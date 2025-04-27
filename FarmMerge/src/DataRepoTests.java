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
        DataRepository db = DataRepository.getInstance();
        db.connectToDatabase(
                "user1",
                "helloworld");
        db.getBoard();
        assertEquals(3,db.countNumberOfCastles());
    }
}
