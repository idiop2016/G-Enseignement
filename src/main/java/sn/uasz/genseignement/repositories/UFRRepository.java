package sn.uasz.genseignement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.uasz.genseignement.entities.UFR;
@RepositoryRestResource
public interface UFRRepository extends JpaRepository<UFR, Long> {
}
