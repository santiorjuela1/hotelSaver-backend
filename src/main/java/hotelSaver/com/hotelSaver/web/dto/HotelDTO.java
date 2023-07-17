package hotelSaver.com.hotelSaver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
