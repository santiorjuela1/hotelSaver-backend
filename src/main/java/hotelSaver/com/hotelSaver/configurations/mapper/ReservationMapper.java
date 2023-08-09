package hotelSaver.com.hotelSaver.configurations.mapper;

import hotelSaver.com.hotelSaver.model.entities.ReservationEntity;
import hotelSaver.com.hotelSaver.web.dto.ReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class ReservationMapper {
    @Mappings({
            @Mapping(target = "fechaInicio", source = "reservationDTO.fechaInicio", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "fechaFin", source = "reservationDTO.fechaFin", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "userEntity.userID.documento", source = "reservationDTO.documento"),
            @Mapping(target = "userEntity.userID.tipoDocumento", source = "reservationDTO.tipoDocumento"),
            @Mapping(target = "hotelEntity.id", source = "reservationDTO.hotelID") // Assuming "nombre" is the property name for hotel's name in HotelEntity
    })
    public abstract ReservationEntity toReservationEntity(ReservationDTO reservationDTO);

    @Mapping(target = "fechaInicio", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "fechaFin", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "cedulas", target = "cedulas")
    @Mapping(source = "hotelEntity.id", target = "hotelID") // Assuming "id" is the property name for hotel's ID in HotelEntity
    @Mapping(source = "userEntity.userID.documento", target = "documento")
    @Mapping(source = "userEntity.userID.tipoDocumento", target = "tipoDocumento")
    public abstract ReservationDTO toReservationDTO(ReservationEntity reservationEntity);
}