package hotelSaver.com.hotelSaver.web.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private String id;
    private String nombre;
    private Integer capacidadReserva;
    private String telefono;
    private String correo;
    private Integer numeroHabitaciones;
    private Float precioNoche;
    private String contrasena;
    private Integer estrellas;
    private String direccion;
}


