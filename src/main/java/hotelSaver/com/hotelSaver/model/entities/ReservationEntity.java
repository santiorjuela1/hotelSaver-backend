package hotelSaver.com.hotelSaver.model.entities;

import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "hotelID", column = @Column(name = "hotel_id"))
    })
    @AssociationOverride(name = "userID",
            joinColumns = {
                    @JoinColumn(name = "user_documento", referencedColumnName = "documento"),
                    @JoinColumn(name = "user_tipo_documento", referencedColumnName = "tipoDocumento")
            })
    private ReservationID reservationID;


    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    private Integer numeroHabitaciones;

    /*@OneToMany(mappedBy = "reservationEntity")
    private List<UserEntity> cedulas;*/
}
