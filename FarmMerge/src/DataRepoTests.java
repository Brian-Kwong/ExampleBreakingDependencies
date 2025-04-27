import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataRepoTests {
    @Test
    void createRepo() {
        DataRepository db = DataRepository.getInstance();
        assertEquals(db.getClass(), DataRepository.class);
    }
}
