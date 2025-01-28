package sn.uasz.genseignement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GEnseignementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GEnseignementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}