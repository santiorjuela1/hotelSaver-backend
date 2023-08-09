package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.configurations.mapper.UserMapper;
import hotelSaver.com.hotelSaver.model.entities.UserEntity;
import hotelSaver.com.hotelSaver.model.entities.UserID;
import hotelSaver.com.hotelSaver.model.repositories.UserRepository;
import hotelSaver.com.hotelSaver.service.interfaces.UserService;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import hotelSaver.com.hotelSaver.web.exceptions.types.BadRequestException;
import hotelSaver.com.hotelSaver.web.exceptions.types.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO createUsuario(UserDTO userDTO) {
        if(userDTO.getUserID().getDocumento() == null && userDTO.getUserID().getTipoDocumento().isEmpty()){
            throw new BadRequestException("You have to introduce an id!");
        }

        UserEntity userEntity = userMapper.userDTOToUserEntity(userDTO);

        userRepository.save(userEntity);

       return userMapper.userEntityToUserDTO(userEntity);
    }

    @Override
    public UserDTO getUsuario(Long documento, String tipoDocumento) {
        UserID userID = new UserID(documento, tipoDocumento);

        UserEntity userEntity = userRepository.findById(userID).
                orElseThrow(() -> new NotFoundException("Could not find ID: "+documento + "," + tipoDocumento));

        return userMapper.userEntityToUserDTO(userEntity);
    }

    @Override
    public HttpStatus deleteUsuario(Long documento, String tipoDocumento ) {
        UserID userID = new UserID(documento, tipoDocumento);

        UserEntity userEntity = userRepository.findById(userID).
                orElseThrow(() -> new NotFoundException("Could not find ID"));

        userRepository.delete(userEntity);
        return HttpStatus.NO_CONTENT;
    }

    @Override
    public UserDTO updateUsuario(UserDTO userDTO) {

        UserEntity userEntity = userRepository.findById(userDTO.getUserID())
                .orElseThrow(() -> new NotFoundException("Id was not found"));

       UserEntity userUpdated = userMapper.userDTOToUserEntity(userDTO);

        userRepository.save(userUpdated);

        return userMapper.userEntityToUserDTO(userUpdated);
    }

    @Override
    public List<UserDTO> findAllUsers(){
         List<UserEntity> allUsersDTO = userRepository.findAll();

         return allUsersDTO.stream()
                 .map((eachUserEntity) -> userMapper.userEntityToUserDTO(eachUserEntity)).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByCorreo(String correo) {
       UserEntity userEntity = userRepository.findByCorreo(correo).
               orElseThrow(() -> new NotFoundException("Correo not found"));

       return userMapper.userEntityToUserDTO(userEntity);
    }
}
