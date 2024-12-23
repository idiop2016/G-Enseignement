package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entité représentant un étudiant dans le système de gestion des enseignements.
 * Cette classe gère les informations personnelles d'un étudiant ainsi que
 * ses inscriptions et son compte utilisateur associé.
 */
@Entity
@Table(name = "etudiants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Etudiant {
    /**
     * Identifiant unique auto-généré de l'étudiant
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom de famille de l'étudiant
     */
    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable = false, length = 100)
    private String nom;

    /**
     * Prénom(s) de l'étudiant
     */
    @NotBlank(message = "Le prénom est obligatoire")
    @Column(nullable = false, length = 100)
    private String prenom;

    /**
     * Adresse de résidence de l'étudiant
     */
    @Column(length = 255)
    private String adresse;

    /**
     * Date de naissance de l'étudiant
     */
    @NotNull(message = "La date de naissance est obligatoire")
    @Past(message = "La date de naissance doit être dans le passé")
    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    /**
     * Lieu de naissance de l'étudiant
     */
    @NotBlank(message = "Le lieu de naissance est obligatoire")
    @Column(name = "lieu_naissance", nullable = false, length = 100)
    private String lieuDeNaissance;

    /**
     * Liste des inscriptions de l'étudiant
     * Utilise CascadeType.ALL pour la gestion automatique des inscriptions
     */
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Inscription> inscriptions = new ArrayList<>();

    /**
     * Compte utilisateur associé à l'étudiant
     * Relation one-to-one avec chargement lazy
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private Utilisateur user;

    /**
     * Identifiant de l'utilisateur ayant créé l'enregistrement
     */
    @Column(name = "created_by", nullable = false, length = 50)
    private String createdBy;

    /**
     * Date et heure de création de l'enregistrement
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Identifiant de l'utilisateur ayant effectué la dernière modification
     */
    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    /**
     * Date et heure de la dernière modification
     */
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Ajoute une inscription à la liste des inscriptions de l'étudiant
     * @param inscription L'inscription à ajouter
     */
    public void addInscription(Inscription inscription) {
        inscriptions.add(inscription);
        inscription.setEtudiant(this);
    }

    /**
     * Retire une inscription de la liste des inscriptions de l'étudiant
     * @param inscription L'inscription à retirer
     */
    public void removeInscription(Inscription inscription) {
        inscriptions.remove(inscription);
        inscription.setEtudiant(null);
    }
}