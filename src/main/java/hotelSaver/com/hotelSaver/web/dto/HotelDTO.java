package hotelSaver.com.hotelSaver.web.dto;

import hotelSaver.com.hotelSaver.model.entities.ReservationEntity;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private String id;
    private String nombre;
    private Integer capacidadReserva;
    private String telefono;
    private String correoElectronico;
    private Integer numeroHabitaciones;
    private Float precioNoche;
}


