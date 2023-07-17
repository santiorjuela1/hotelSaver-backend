package hotelSaver.com.hotelSaver.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    //documento, tipoDocumento
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "documento", column = @Column(name = "documento")),
            @AttributeOverride(name = "tipoDocumento", column = @Column(name = "tipo_documento"))
    })
    private UserID userID;

    private String nombre;

    private String correo;

    private String contrasena;

    private String telefono;

    /*@ManyToOne
    @JoinColumns({
            @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id"),
            @JoinColumn(name = "user_documento", referencedColumnName = "user_documento"),
            @JoinColumn(name = "user-tipo-documento", referencedColumnName = "user_tipo_documento")
    })
    ReservationEntity reservationEntity;*/
}
