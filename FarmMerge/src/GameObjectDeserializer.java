import com.google.gson.*;

import java.lang.reflect.Type;

public class GameObjectDeserializer implements JsonDeserializer<GameObjects> {
    @Override
    public GameObjects deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String gameObjectType = jsonObject.get("type").getAsString();
        return switch (gameObjectType) {
            case "Cow" -> jsonDeserializationContext.deserialize(jsonObject, Cow.class);
            case "Chicken" -> jsonDeserializationContext.deserialize(jsonObject, Chicken.class);
            case "Pig" -> jsonDeserializationContext.deserialize(jsonObject, Pig.class);
            case "Corn" -> jsonDeserializationContext.deserialize(jsonObject, Corn.class);
            case "Carrot" -> jsonDeserializationContext.deserialize(jsonObject, Carrot.class);
            case "Wheat" -> jsonDeserializationContext.deserialize(jsonObject, Wheat.class);
            case "Coin" -> jsonDeserializationContext.deserialize(jsonObject, Coin.class);
            default -> throw new JsonParseException("Unknown gameObject type: " + gameObjectType);
        };
    }
}
