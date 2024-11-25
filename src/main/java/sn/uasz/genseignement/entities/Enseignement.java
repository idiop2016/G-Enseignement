package sn.uasz.genseignement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Enseignement {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String createby;
    private String createat;
}
