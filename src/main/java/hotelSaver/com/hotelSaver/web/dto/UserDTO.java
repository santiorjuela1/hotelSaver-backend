package hotelSaver.com.hotelSaver.web.dto;

import hotelSaver.com.hotelSaver.model.entities.UserID;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    // Id
    private UserID userID;
    private String nombre;
    private String correo;
    private String contrasena;
    private String telefono;

    UserDTO(Long documento, String tipoDocumento){
        userID.setDocumento(documento);
        userID.setTipoDocumento(tipoDocumento);
    }
}
