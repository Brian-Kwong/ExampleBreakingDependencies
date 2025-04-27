import java.awt.*;
import java.util.List;

public class GameBoardEntry {
    private String id;
    private List<GameObjects> board;

    public GameBoardEntry(String id, List<GameObjects> board) {
        this.id = id;
        this.board = board;
    }

    public String getId() {
        return id;
    }

    public List<GameObjects> getGameBoard(){
        return board;
    }

    @Override
    public String toString() {
        return "GameBoardEntry{" +
                "\n\tid='" + id +
                "\n\tboard=" + board +
                "\n}";
    }
}
