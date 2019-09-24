import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;


import java.util.Map;

public class JsonSerializer<T> implements Serializer<T> {

    private Class<T> tClass;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonSerializer() { }

    public void configure(Map configs, boolean isKey) {

    }

    public byte[] serialize(String topic, T data) {

        if(data == null)
            return null;

        try{
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    public void close() {

    }
}
