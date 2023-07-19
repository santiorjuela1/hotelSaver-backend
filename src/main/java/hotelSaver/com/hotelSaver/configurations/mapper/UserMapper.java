package hotelSaver.com.hotelSaver.configurations.mapper;

import hotelSaver.com.hotelSaver.model.entities.UserEntity;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity userDTOToUserEntity(UserDTO userDTO);
    UserDTO userEntityToUserDTO(UserEntity userEntity);
}
