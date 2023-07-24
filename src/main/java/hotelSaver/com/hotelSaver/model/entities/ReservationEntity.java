package hotelSaver.com.hotelSaver.model.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @EmbeddedId
    private ReservationID reservationID;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    private Integer numeroHabitaciones;

    @OneToMany(mappedBy = "reservationEntity")
    private List<ClienteEntity> cedulas;

    @ManyToOne(targetEntity = HotelEntity.class)
    @JoinColumn(referencedColumnName = "id", name = "hotel_id_hotel")
    private HotelEntity hotelEntity;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(referencedColumnName = "documento", name = "documento_user"),
            @JoinColumn(referencedColumnName = "tipo_documento", name = "tipo_documento_user")
    })
    private UserEntity userEntity;
}
