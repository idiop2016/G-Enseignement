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
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String dateNaissance;
    private String lieuDeNaissance;
    //private List<Inscription> inscriptions;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Utilisateur user;
    private String createby;
    private String createat;
}