import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(Integer.parseInt(args[0]));
        File path = new File("/home/kumar/Downloads/assignments/KafkaRequirement/data");

        for (File fileName :path.listFiles()) {
            System.out.println("Reading the fileName : "+fileName.toString());
            service.execute(new Writer(fileName));
        }
    }
}