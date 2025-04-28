import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;

public class TestDataRepo extends DataRepository{

    public void  connectToDatabase(Player user){
        this.user = user;
    }

    public void getBoard(String data){
        Gson gson = new GsonBuilder().registerTypeAdapter(
                GameObjects.class, new GameObjectDeserializer()
        ).registerTypeAdapter(Color.class, new ColorJSONAdaptor()).registerTypeAdapter(Point.class, new PointJSONAdaptorClass()).create();
        GameBoardEntry gameEntry = gson.fromJson(data, GameBoardEntry.class);
        this.gameObjects = gameEntry.getGameBoard();
    }
}
