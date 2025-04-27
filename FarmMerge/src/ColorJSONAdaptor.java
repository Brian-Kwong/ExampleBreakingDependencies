import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.awt.*;
import java.io.IOException;

public class ColorJSONAdaptor extends TypeAdapter<Color> {

    @Override
    public void write(JsonWriter jsonWriter, Color color) throws IOException {
        if(color == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();
            jsonWriter.value(color.getRed());
            jsonWriter.value(color.getGreen());
            jsonWriter.value(color.getBlue());
            jsonWriter.endArray();
        }

    }

    @Override
    public Color read(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int red = jsonReader.nextInt();
        int green = jsonReader.nextInt();
        int blue = jsonReader.nextInt();
        jsonReader.endArray();
        return new Color(red, green, blue);
    }
}
