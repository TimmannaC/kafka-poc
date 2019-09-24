import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

public class Writer implements Runnable{

    private File filePath;
    private Properties kafkaProps = new Properties();
    private Producer kafkaProducer = null;
    private String topic = null;

    public Writer(File fileName){
        this.filePath = fileName;
        this.kafkaProps.put("bootstrap.servers","localhost:9092");
        this.kafkaProducer = new KafkaProducer(kafkaProps,new StringSerializer(),new JsonSerializer());
    }

    public String getFilePath() {
        return filePath.toString();
    }

    @Override
    public void run() {

        try(Scanner sc = new Scanner(this.filePath)){
            String header= sc.next();
            while (sc.hasNext()){
                System.out.println(sc.nextLine());
            }
        }
        catch (FileNotFoundException f){
            System.out.println(f);
        }
    }
}