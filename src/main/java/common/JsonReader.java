package common;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReader {
    public static Map<String, String> readJson(String filePath) {
        try {
            return new ObjectMapper().readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + e.getMessage());
        }
    }
}
