package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date debut;
    private Date fin;

    @ManyToOne
    private EmploisDuTemps emploisDuTemps;

    @ManyToOne
    private Enseignement enseignement;

    @ManyToOne
    private Salle salle;

}
