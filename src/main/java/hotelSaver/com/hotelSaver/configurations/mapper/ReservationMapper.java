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
            @Mapping(target = "fechaFin", source = "reservationDTO.fechaFin", dateFormat = "yyyy-MM-dd")
    })
    public abstract ReservationEntity toReservationEntity(ReservationDTO reservationDTO);
    public abstract ReservationDTO toReservationDTO(ReservationEntity reservationEntity);
}
