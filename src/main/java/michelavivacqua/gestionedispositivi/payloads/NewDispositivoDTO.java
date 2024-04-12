package michelavivacqua.gestionedispositivi.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import michelavivacqua.gestionedispositivi.enums.StatoDispositivo;

public record NewDispositivoDTO(
        @NotEmpty(message = "È obbligatoria la tipologia")
        @Size(min = 2, max = 30, message = "La tipologia deve essere compresa tra i 2 e i 30 caratteri")
        String tipologia,
        @NotNull(message = "Lo stato è obbligatorio")
        StatoDispositivo stato,
        Integer dipendenteId
) {
}
