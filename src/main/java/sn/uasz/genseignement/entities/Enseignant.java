package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String status;
    private String grade;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Utilisateur user;

    @OneToMany
    private List<Choix> choixes;

    private String createdby;
    private String createat;
}
