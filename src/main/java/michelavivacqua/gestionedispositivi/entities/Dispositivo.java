package michelavivacqua.gestionedispositivi.entities;

import jakarta.persistence.*;
import lombok.*;
import michelavivacqua.gestionedispositivi.enums.StatoDispositivo;

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
    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo(String tipologia, StatoDispositivo stato) {
        this.tipologia = tipologia;
        this.stato = stato;
    }
}
