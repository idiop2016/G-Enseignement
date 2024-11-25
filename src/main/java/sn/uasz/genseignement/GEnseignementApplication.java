package sn.uasz.genseignement;

import sn.uasz.genseignement.entities.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.uasz.genseignement.repositories.EnseignantRepository;

import java.util.List;

@SpringBootApplication
public class GEnseignementApplication implements CommandLineRunner {

    @Autowired
    EnseignantRepository enseignantRepository;

    public static void main(String[] args) {
        SpringApplication.run(GEnseignementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        enseignantRepository.save(new Enseignant(null,"181185/D","Diop","Ibrahima",null,null,null,null,null,null,null,null));
        enseignantRepository.save(new Enseignant(null,"181186/A","Fall","Modou",null,null,null,null,null,null,null,null));
        enseignantRepository.save(new Enseignant(null,"181187/B","Ndiaye","Ibrahima",null,null,null,null,null,null,null,null));
        List<Enseignant> enseignents = enseignantRepository.findByPrenomContainsIgnoreCase("Ibra");
        enseignents.forEach(enseignant -> {
            System.out.println("--------------------");
            System.out.println(enseignant.getPrenom());
            System.out.println(enseignant.getNom());
            System.out.println(enseignant.getMatricule());
            System.out.println(enseignant.getGrade());
        });
    }
}