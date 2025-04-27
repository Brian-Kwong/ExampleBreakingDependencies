import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.awt.*;
import java.io.IOException;

public class PointJSONAdaptorClass extends TypeAdapter<Point> {
    @Override
    public void write(JsonWriter jsonWriter, Point point) throws IOException {
        if(point == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();
            jsonWriter.value(point.x);
            jsonWriter.value(point.y);
            jsonWriter.endArray();
        }
    }

    @Override
    public Point read(JsonReader jsonReader) throws IOException {
            jsonReader.beginArray();
            int x = jsonReader.nextInt();
            int y = jsonReader.nextInt();
            jsonReader.endArray();
            return new Point(x, y);
        }
}
