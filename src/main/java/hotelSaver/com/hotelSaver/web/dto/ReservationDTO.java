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
    private HotelDTO hotelDTO;
    private UserDTO userDTO;

    public ReservationDTO(String fechaInicio, String fechaFin,
                          Integer numeroHabitaciones, List<ClienteDTO> cedulas) {

        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroHabitaciones = numeroHabitaciones;
        this.cedulas = cedulas;

    }
}
