import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class Consumer {

    private String topic= "kafka-poc1";
    private Properties properties = new Properties();
    private KafkaConsumer<String,StockMarket> consumer = null;

    public Consumer(){
        this.properties.put("bootstrap.servers","localhost:9092");
        this.properties.put("group.id","6");
        this.properties.put("enable.auto.commit","false");
        this.properties.put("auto.offset.reset","earliest");
        this.properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        this.properties.put("value.deserializer","JsonDeSerializer");
        this.consumer = new KafkaConsumer<String, StockMarket>(this.properties);
        this.consumer.subscribe(Collections.singleton(this.topic));
    }

    public void ConsumeRecords(){
        try{
            while (true){
                ConsumerRecords<String, StockMarket> records = consumer.poll(0);
                for (ConsumerRecord<String,StockMarket> record : records){
                    System.out.println(record.value().toString());
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Consumer c = new Consumer();
        c.ConsumeRecords();
    }
}