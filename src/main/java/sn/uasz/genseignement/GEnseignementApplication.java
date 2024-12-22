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
        Enseignant e1 =Enseignant.builder()
                .matricule("181185/D")
                .nom("Diop")
                .prenom("Ibrahima")
                .build();
        enseignantRepository.save(e1);

        Enseignant e2 = Enseignant.builder()
                .matricule("181186/A")
                .nom("Fall")
                .prenom("Modou")
                .build();
        enseignantRepository.save(e2);

        Enseignant e3 = Enseignant.builder()
                .matricule("181187/B")
                .nom("Ndiaye")
                .prenom("Ibrahima")
                .build();
        enseignantRepository.save(e3);

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