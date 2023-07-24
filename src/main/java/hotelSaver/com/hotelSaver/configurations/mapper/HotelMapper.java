package hotelSaver.com.hotelSaver.configurations.mapper;

import hotelSaver.com.hotelSaver.model.entities.HotelEntity;
import hotelSaver.com.hotelSaver.web.dto.HotelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class HotelMapper {
    public abstract HotelEntity toHotelEntity(HotelDTO hotelDTO);
    public abstract HotelDTO toHotelDTO(HotelEntity hotelEntity);
}
