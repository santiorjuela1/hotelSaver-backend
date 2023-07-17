package hotelSaver.com.hotelSaver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "hoteles")
public class HotelEntity {
    @Id
    @Column(nullable = false)
    private String id;

    private String nombre;

    private Integer capacidadReserva;

    private String telefono;

    private String correoElectronico;

    private Integer numeroHabitaciones;

    private Float precioNoche;
}
