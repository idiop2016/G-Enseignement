package repositories;

import entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
    public List<Enseignant> findByPrenomContainsIgnoreCase(String kw);
}
