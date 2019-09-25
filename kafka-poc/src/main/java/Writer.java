import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;


public class Writer implements Runnable{

    private File filePath;
    private Properties kafkaProps = new Properties();
    private Producer kafkaProducer = null;
    private String topic = "kafka-poc1";

    public Writer(File fileName){
        this.filePath = fileName;
        this.kafkaProps.put("bootstrap.servers","localhost:9092");
        this.kafkaProducer = new KafkaProducer(kafkaProps,new StringSerializer(),new StringSerializer());
    }

    public String getFilePath() {
        return filePath.toString();
    }

    @Override
    public void run() {

        try(Scanner sc = new Scanner(this.filePath)){
            String header= sc.next();
            while (sc.hasNext()){
                String[] data = sc.nextLine().split(",");

                /*ProducerRecord<String,String> record = new ProducerRecord<>(topic,data);
                kafkaProducer.send(record).get();*/

            }
        }
        catch (FileNotFoundException f){
            System.out.println(f);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("############ End of File processing ##############");
    }
}