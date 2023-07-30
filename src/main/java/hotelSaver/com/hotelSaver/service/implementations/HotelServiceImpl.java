package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.configurations.mapper.HotelMapper;
import hotelSaver.com.hotelSaver.model.entities.HotelEntity;
import hotelSaver.com.hotelSaver.model.repositories.HotelRepository;
import hotelSaver.com.hotelSaver.service.interfaces.HotelService;
import hotelSaver.com.hotelSaver.web.dto.HotelDTO;
import hotelSaver.com.hotelSaver.web.exceptions.types.BadRequestException;
import hotelSaver.com.hotelSaver.web.exceptions.types.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        if(hotelDTO.getId() == null){
            throw new BadRequestException("Not valid id");
        }
        HotelEntity hotelEntity =
                hotelRepository.save(hotelMapper.toHotelEntity(hotelDTO));

        return hotelMapper.toHotelDTO(hotelEntity);
    }

    @Override
    public HotelDTO getHotel(String id) {
       HotelEntity hotelEntity =  hotelRepository.findById(id).
                orElseThrow(() -> new NotFoundException("id: " + id + " not found"));

       return hotelMapper.toHotelDTO(hotelEntity);
    }

    @Override
    public HttpStatus deleteHotel(String id) {
        HotelEntity hotelEntity = hotelRepository.findById(id).
                orElseThrow(() -> new NotFoundException("id not found"));

        hotelRepository.delete(hotelEntity);

        return HttpStatus.NO_CONTENT;
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        HotelEntity hotelEntity = hotelRepository.findById(hotelDTO.getId())
                .orElseThrow(() -> new NotFoundException("Hotel with ID not found"));

        HotelEntity hotelUpdated = hotelRepository.save(hotelMapper.toHotelEntity(hotelDTO));

        return hotelMapper.toHotelDTO(hotelUpdated);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        List<HotelEntity> hotelEntities = hotelRepository.findAll();

        List<HotelDTO> hotelDTOS = hotelEntities.stream().
                map((eachHotelEntity) -> hotelMapper.toHotelDTO(eachHotelEntity)).
                collect(Collectors.toList());

        return hotelDTOS;
    }
}
