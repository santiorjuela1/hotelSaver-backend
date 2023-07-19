package hotelSaver.com.hotelSaver.web.dto;

import hotelSaver.com.hotelSaver.model.entities.UserID;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    // Id
    private UserID userID;
    private String nombre;
    private String correo;
    private String contrasena;
    private String telefono;
}
