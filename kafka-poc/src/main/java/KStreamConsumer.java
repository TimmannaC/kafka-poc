import com.github.luben.zstd.ZstdOutputStream;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.w3c.dom.ls.LSOutput;

import java.util.Date;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;

public class KStreamConsumer {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"stock-consumer-2");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        Map<String, Object> serdeProps = new HashMap<>();

        final Serializer<StockMarket> stockMarketSerializer = new JsonSerializer<>();
        serdeProps.put("JsonPOJOClass", StockMarket.class);
        stockMarketSerializer.configure(serdeProps,false);

        final Deserializer<StockMarket> stockMarketDeserializer = new JsonDeSerializer<>();
        serdeProps.put("JsonPOJOClass", StockMarket.class);
        stockMarketDeserializer.configure(serdeProps,false);

        final Serde<StockMarket> stockMarketSerde = Serdes.serdeFrom(stockMarketSerializer,stockMarketDeserializer);


        StreamsBuilder builder = new StreamsBuilder();

        StreamsConfig config = new StreamsConfig(properties);

        KStream<String,StockMarket> stockStream = builder.stream("kafka-poc1", Consumed.with(Serdes.String(), stockMarketSerde));


        //stockStream.foreach((k,v) -> System.out.println("key : "+k+"Value : "+v.toString()));
        KStream<Integer,StockMarket> keyValueStream = stockStream.map(
                (key, value) -> KeyValue.pair(value.getTimestamp().getDate(),value)
        );

        keyValueStream.foreach((k,v) -> System.out.println("key : "+k+"  Value : "+v.toString()));

        //KTable<Integer,StockMarket> groupByKey = keyValueStream.groupByKey();

        //groupByKey.toStream().foreach((k,v) -> System.out.println(" key is  :  "+k+ "  value is     :   "+v));

       // System.out.println(groupByKey.count());

        KafkaStreams streams = new KafkaStreams(builder.build(),config);
        streams.start();
    }
}