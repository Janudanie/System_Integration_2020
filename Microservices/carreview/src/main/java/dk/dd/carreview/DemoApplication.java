package dk.dd.carreview;

import com.mongodb.internal.operation.CreateCollectionOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ReviewRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    repository.deleteAll();
    repository.save(new Review("123","Nice Car", "Mini"));
    repository.save(new Review("145","wish i had one","Skoda"));
    repository.save(new Review("145","wish i had one","skoda"));
    }
}
