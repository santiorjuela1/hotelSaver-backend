package hotelSaver.com.hotelSaver.service.interfaces;

import hotelSaver.com.hotelSaver.model.entities.UserID;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserDTO createUsuario(UserDTO userDTO);
    UserDTO getUsuario(Long documento, String tipoDocumento);
    HttpStatus deleteUsuario(Long documento);
    UserDTO updateUsuario(UserDTO userDTO);

}


