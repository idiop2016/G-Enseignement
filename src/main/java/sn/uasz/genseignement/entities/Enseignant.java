package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entité représentant un enseignant dans le système de gestion des enseignements.
 * Cette classe gère les informations personnelles et professionnelles d'un enseignant,
 * ainsi que ses relations avec le département, l'utilisateur et ses choix d'enseignement.
 */
@Entity
@Table(name = "enseignants")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder
public class Enseignant {
    /**
     * Identifiant unique auto-généré de l'enseignant
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Matricule unique de l'enseignant
     * Format spécifique à l'institution
     */
    @NotBlank(message = "Le matricule est obligatoire")
    @Column(unique = true, nullable = false, length = 50)
    private String matricule;

    /**
     * Nom de famille de l'enseignant
     */
    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable = false, length = 100)
    private String nom;

    /**
     * Prénom(s) de l'enseignant
     */
    @NotBlank(message = "Le prénom est obligatoire")
    @Column(nullable = false, length = 100)
    private String prenom;

    /**
     * Numéro de téléphone de l'enseignant
     * Format: +221774567890 ou 774567890
     */
    @Pattern(regexp = "^\\+?[0-9]{9,15}$", message = "Le numéro de téléphone doit être valide")
    @Column(length = 20)
    private String telephone;

    /**
     * Adresse email professionnelle de l'enseignant
     */
    @Email(message = "L'email doit être valide")
    @Column(unique = true, length = 100)
    private String email;

    /**
     * Statut actuel de l'enseignant dans l'établissement
     * (ex: Permanent, Vacataire, etc.)
     */
    @NotBlank(message = "Le statut est obligatoire")
    @Column(nullable = false, length = 50)
    private String status;

    /**
     * Grade académique de l'enseignant
     * (ex: Professeur, Maître de conférences, etc.)
     */
    @NotBlank(message = "Le grade est obligatoire")
    @Column(nullable = false, length = 50)
    private String grade;

    /**
     * Département d'affectation de l'enseignant
     * Chargement lazy pour optimiser les performances
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;

    /**
     * Compte utilisateur associé à l'enseignant
     * Relation one-to-one avec chargement lazy
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private Utilisateur user;

    /**
     * Liste des choix d'enseignement de l'enseignant
     * Cascade ALL pour propager les opérations CRUD
     */
    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    private List<Choix> choixes;

    /**
     * Identifiant de l'utilisateur ayant créé l'enregistrement
     */
    @Column(name = "created_by", nullable = false, length = 50)
    private String createdBy;

    /**
     * Date et heure de création de l'enregistrement
     * Générée automatiquement
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
     * Mise à jour automatiquement
     */
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
