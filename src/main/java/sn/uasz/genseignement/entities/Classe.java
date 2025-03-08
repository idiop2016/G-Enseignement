package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    private Niveau niveau;
    private int nbreEtudiant;
    @ManyToOne
    private Formation formation;
    @ManyToOne
    private Cycle cycle;
    @ManyToOne
    private Salle salle;

    private String createby;
    private String createat;
}
