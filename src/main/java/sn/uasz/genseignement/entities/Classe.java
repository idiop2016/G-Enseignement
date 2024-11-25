package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String niveau;
    private int nbreetudiant;
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

/*    @ManyToMany
    private Salle salle;*/

    private String semestre;
    private String createby;
    private String createat;
}
