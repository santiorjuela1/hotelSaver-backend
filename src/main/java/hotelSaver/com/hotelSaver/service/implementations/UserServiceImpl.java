package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.configurations.mapper.UserMapper;
import hotelSaver.com.hotelSaver.model.entities.UserEntity;
import hotelSaver.com.hotelSaver.model.entities.UserID;
import hotelSaver.com.hotelSaver.model.repositories.UserRepository;
import hotelSaver.com.hotelSaver.service.interfaces.UserService;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO createUsuario(UserDTO userDTO) {
        if(userDTO.getUserID().getDocumento() == null && userDTO.getUserID().getTipoDocumento().isEmpty()){
            throw new IllegalArgumentException("You have to introduce an id!");
        }

        UserEntity userEntity = userMapper.userDTOToUserEntity(userDTO);

        userRepository.save(userEntity);

       return userMapper.userEntityToUserDTO(userEntity);
    }

    @Override
    public UserDTO getUsuario(Long documento, String tipoDocumento) {
        UserID userID = new UserID(documento, tipoDocumento);

        UserEntity userEntity = userRepository.findById(userID).
                orElseThrow(() -> new RuntimeException("Could not find ID"));

        return userMapper.userEntityToUserDTO(userEntity);
    }

    @Override
    public HttpStatus deleteUsuario(Long documento, String tipoDocumento ) {
        UserID userID = new UserID(documento, tipoDocumento);

        UserEntity userEntity = userRepository.findById(userID).
                orElseThrow(() -> new RuntimeException("Could not find ID"));

        userRepository.delete(userEntity);
        return HttpStatus.NO_CONTENT;
    }

    @Override
    public UserDTO updateUsuario(UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(userDTO.getUserID())
                .orElseThrow(() -> new RuntimeException("Id was not found"));

       UserEntity userUpdated = userMapper.userDTOToUserEntity(userDTO);

        userRepository.save(userUpdated);

        return userMapper.userEntityToUserDTO(userEntity);
    }
}
