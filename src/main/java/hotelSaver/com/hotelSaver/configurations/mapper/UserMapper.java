package hotelSaver.com.hotelSaver.configurations.mapper;

import hotelSaver.com.hotelSaver.model.entities.UserEntity;
import hotelSaver.com.hotelSaver.model.entities.UserID;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import hotelSaver.com.hotelSaver.web.dto.UserIdDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Mappings({
            @Mapping(target = "userID", source = "userDTO.userID"),
            @Mapping(target = "nombre", source = "userDTO.nombre"),
            @Mapping(target = "correo", source = "userDTO.correo"),
            @Mapping(target = "contrasena", source = "userDTO.contrasena"),
            @Mapping(target = "telefono", source = "userDTO.telefono"),
/*           @Mapping(target = "reservationEntity.hotel_id", source = "userDTO.hotelID"),
            @Mapping(target = "reservationEntity.hotel_id", source = "userDTO.documento"),
            @Mapping(target = "reservationEntity.hotel_id", source = "userDTO.tipoDocumento")*/
    })
    public abstract UserEntity userDTOToUserEntity(UserDTO userDTO);
    public abstract  UserDTO userEntityToUserDTO(UserEntity userEntity);

    public abstract UserIdDTO  UserIDTOUserIdDTO(UserID userID);
    public abstract UserID UserIdDTOToUserID(UserIdDTO userIdDTO);
}
