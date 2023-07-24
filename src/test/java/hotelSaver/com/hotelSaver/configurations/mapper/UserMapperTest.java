package hotelSaver.com.hotelSaver.configurations.mapper;
import hotelSaver.com.hotelSaver.model.entities.UserEntity;
import hotelSaver.com.hotelSaver.model.entities.UserID;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);


    @Test
    public void userMapperTestUserDTOToUserEntity(){


        UserDTO userDTO = new UserDTO();
        UserID userID = new UserID(10000L, "ti");

        userDTO.setUserID(userID);
        userDTO.setNombre("santiago");
        userDTO.setCorreo("santi");
        userDTO.setContrasena("hola123");
        userDTO.setTelefono("30512121");


        UserEntity userEntity = userMapper.userDTOToUserEntity(userDTO);

        Assertions.assertEquals(userDTO.getUserID(), userEntity.getUserID());
        Assertions.assertEquals(userEntity.getUserID().getDocumento(), userDTO.getUserID().getDocumento());
        Assertions.assertEquals(userEntity.getUserID().getTipoDocumento(), userDTO.getUserID().getTipoDocumento());
        Assertions.assertEquals(userEntity.getNombre(), userDTO.getNombre());
        Assertions.assertEquals(userEntity.getCorreo(), userDTO.getCorreo());
        Assertions.assertEquals(userEntity.getContrasena(), userDTO.getContrasena());
        Assertions.assertEquals(userEntity.getTelefono(), userDTO.getTelefono());
    }

}