import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;



public class JsonDeSerializer<T> implements Deserializer<T> {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> tClass;

    public JsonDeSerializer() { }

    public void configure(Map<String, ?> configs, boolean isKey) {
        this.tClass = (Class<T>) configs.get("JsonPOJOClass");
    }

    public T deserialize(String topic, byte[] bytes) {
        if (bytes == null)
            return null;

        T data=null;
        try{
            data = objectMapper.readValue(bytes,tClass);
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void close() {
    }
}
