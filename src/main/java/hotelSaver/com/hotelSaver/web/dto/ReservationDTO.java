package hotelSaver.com.hotelSaver.web.dto;

import hotelSaver.com.hotelSaver.model.entities.ReservationID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private ReservationID reservationID;
    private String fechaInicio;
    private String fechaFin;
    private Integer numeroHabitaciones;
    private List<ClienteDTO> cedulas;
    private String hotelID;
    private Long documento;
    private String tipoDocumento;
}
