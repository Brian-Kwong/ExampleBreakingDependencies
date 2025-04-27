import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class DataRepository {

    private static final String BACKEND_URL = "http://localhost:5000";
    private static DataRepository instance;
    private Player user;
    private List<GameObjects> gameObjects;
    private DataRepository() {
    }
    public static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    public Player getUser() {
        return user;
    }

    public void connectToDatabase(String username, String password) throws IOException, InterruptedException {
        // Simulate a database connection
        System.out.println("Connecting to database..." +  URI.create(BACKEND_URL + "/getUser?" + "username=" + username + "&password=" + password ).toString());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(
                URI.create(BACKEND_URL + "/getUser?" + "username=" + username + "&password=" + password )).GET().build();
        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            // Parse the response to create a User object
            String responseBody = response.body();
            Gson gson = new Gson();
            // Set the user object
            this.user = gson.fromJson(responseBody, Player.class);
        }
        else {
            // Handle the error
            System.out.println("Error: " + response.statusCode());
        }
    }

    public void disconnectFromDatabase() {
        this.user = null;
    }

    public void getBoard() throws IOException, InterruptedException {
        if(user == null) {
            System.out.println("User is not connected to the database.");
        } else {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(
                    URI.create(BACKEND_URL + "/get_board_data/" + user.username)).GET().build();
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // Parse the response to create a Board object
                String responseBody = response.body();
                Gson gson = new GsonBuilder().registerTypeAdapter(
                        GameObjects.class, new GameObjectDeserializer()
                ).registerTypeAdapter(Color.class, new ColorJSONAdaptor()).registerTypeAdapter(Point.class, new PointJSONAdaptorClass()).create();
                GameBoardEntry gameEntry = gson.fromJson(responseBody, GameBoardEntry.class);
                this.gameObjects = gameEntry.getGameBoard();
            } else {
                // Handle the error
                System.out.println("Error: " + response.statusCode());
            }
        }
    }

    public String[] getCDFAData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(
                URI.create(BACKEND_URL + "/get_cdfa_data")).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            String responseBody = response.body();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, String[].class);
        } else {
            System.out.println("Error: " + response.statusCode());
            return null;
        }
    }

    public int countNumberOfCastles() throws IOException, InterruptedException {
        if(user == null) {
            return 0;
        }
        if(gameObjects == null) {
            getBoard();
        }
        int count = 0;
        for (GameObjects gameObject : gameObjects) {
            if (gameObject instanceof FarmAnimal) {
                count++;
            }
        }
        return count;
    }
}
