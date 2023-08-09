package hotelSaver.com.hotelSaver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {
    private Long documento;
    private String tipoDocumento;
    private ReservationDTO reservationDTO;
}
