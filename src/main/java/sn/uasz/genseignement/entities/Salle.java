package sn.uasz.genseignement.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Salle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String typeSalle;
    private int nbrePlaces;
    private String batiment;
    private boolean climatisation;
    private String commentaire;
    private boolean activer;

    private String createby;
    private String createat;
}
