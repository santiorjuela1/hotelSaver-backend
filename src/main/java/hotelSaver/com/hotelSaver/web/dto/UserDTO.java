package hotelSaver.com.hotelSaver.web.dto;

import hotelSaver.com.hotelSaver.model.entities.UserID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    // Id
    UserID userID;
    // Rest
    private String nombre;
    private String correo;
    private String contrasena;
    private String telefono;

    UserDTO(UserID userID){
        this.userID = userID;
    }
}
