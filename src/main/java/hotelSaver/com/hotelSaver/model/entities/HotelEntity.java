package hotelSaver.com.hotelSaver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
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

    @OneToMany(mappedBy = "hotelEntity")
    private List<ReservationEntity> reservationEntityList;
}
