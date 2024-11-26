package sn.uasz.genseignement.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Salle {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
