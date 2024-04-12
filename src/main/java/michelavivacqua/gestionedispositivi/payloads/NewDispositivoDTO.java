package michelavivacqua.gestionedispositivi.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewDispositivoDTO(
        @NotEmpty(message = "È obbligatoria la tipologia")
        @Size(min = 2, max = 30, message = "La tipologia deve essere compresa tra i 2 e i 30 caratteri")
        String tipologia,
        @NotEmpty(message = "Lo stato è obbligatorio")
        @Size(min = 2, max = 30, message = "Lo stato deve essere compreso tra i 2 e i 30 caratteri")
        String stato,
        Integer dipendenteId
) {
}
