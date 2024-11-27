package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmploisDuTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heureDebut;
    private String heureFin;
    @OneToMany
    private List<Seance> seances;
}
