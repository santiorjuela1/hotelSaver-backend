package hotelSaver.com.hotelSaver.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "userEntity")
    private List<ReservationEntity> resevations;

}
