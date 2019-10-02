import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Writer implements Runnable{

    private File filePath;
    private Properties kafkaProps = new Properties();
    private Producer kafkaProducer = null;
    private String topic = "kafka-poc1";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");   //08-JAN-2019

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
                String[] records = sc.next().split(",");
                StockMarket stockMarket = new StockMarket();
                stockMarket.setSymbol(records[0]);
                stockMarket.setSeries(records[1]);
                stockMarket.setOpen(Float.parseFloat(records[2]));
                stockMarket.setHigh(Float.parseFloat(records[3]));
                stockMarket.setLow(Float.parseFloat(records[4]));
                stockMarket.setClose(Float.parseFloat(records[5]));
                stockMarket.setLast(Float.parseFloat(records[6]));
                stockMarket.setPrevClose(Float.parseFloat(records[7]));
                stockMarket.setTotTrdQty(Float.parseFloat(records[8]));
                stockMarket.setTotTrdVal(Float.parseFloat(records[9]));
                stockMarket.setTimestamp(dateFormat.parse(records[10]));
                stockMarket.setTotalTrades(Float.parseFloat(records[11]));
                stockMarket.setIsin(records[12]);

                ProducerRecord<String,StockMarket> record = new ProducerRecord<>(topic,stockMarket);
                kafkaProducer.send(record).get();
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