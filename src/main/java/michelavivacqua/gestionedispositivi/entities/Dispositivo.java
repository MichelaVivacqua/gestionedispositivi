package michelavivacqua.gestionedispositivi.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipologia;
    @ManyToOne(optional = true)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;
}
