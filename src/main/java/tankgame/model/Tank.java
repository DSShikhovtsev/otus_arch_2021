package tankgame.model;

import tankgame.utils.UObject;

import java.util.HashMap;
import java.util.Map;

public class Tank implements UObject {

    private final Map<String, Object> properties = new HashMap<>();

    @Override
    public Object getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }
}
