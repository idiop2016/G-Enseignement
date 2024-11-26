package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToOne
    private Maquette maquette;
    @ManyToOne
    private Salle salle;
    private String semestre;

    private String createby;
    private String createat;
}
