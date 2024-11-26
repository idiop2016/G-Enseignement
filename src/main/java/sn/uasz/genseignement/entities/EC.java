package sn.uasz.genseignement.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class EC {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;
    private int credits;
    private int coef;
    private int cm;
    private int td;
    private int tp;
    private int tpe;
    private  String semestre;
    @ManyToOne
    @JoinColumn(name = "ue_id")
    private UE ue;
    private String createby;
    private String createat;
}
