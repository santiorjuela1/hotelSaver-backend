package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.service.interfaces.UserService;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO createUsuario(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUsuario(Long documento) {
        return null;
    }

    @Override
    public HttpStatus deleteUsuario(Long documento) {
        return null;
    }

    @Override
    public UserDTO updateUsuario(UserDTO userDTO) {
        return null;
    }
}
