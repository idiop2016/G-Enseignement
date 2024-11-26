package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Maquette {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @OneToMany
    private List<UE> ues;

    private String createby;
    private String createat;
}
