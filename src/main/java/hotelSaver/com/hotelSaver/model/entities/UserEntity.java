package hotelSaver.com.hotelSaver.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity {

    //documento, tipoDocumento
    @EmbeddedId
    private UserID userID;

    private String nombre;

    private String correo;

    private String contrasena;

    private String telefono;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id"),
            @JoinColumn(name = "user_documento", referencedColumnName = "documento"),
            @JoinColumn(name = "user_tipo_documento", referencedColumnName = "tipo_documento")
    })
    ReservationEntity reservationEntity;
}
