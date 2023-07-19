package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.model.entities.HotelEntity;
import hotelSaver.com.hotelSaver.model.repositories.HotelRepository;
import hotelSaver.com.hotelSaver.service.interfaces.HotelService;
import hotelSaver.com.hotelSaver.web.dto.HotelDTO;
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
    ModelMapper modelMapper;

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        // Making sure the ID is unique
        UUID resourceId = UUID.randomUUID();
        String currentId = hotelDTO.getId();
        String uniqueId;

        if(currentId != null && !currentId.isEmpty()){
            uniqueId = currentId + "-" + resourceId;
        }
        else{
            throw new RuntimeException("The id cannot be empty!");
        }
        HotelEntity hotelEntity =
                hotelRepository.save(modelMapper.map(hotelDTO, HotelEntity.class));

        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    @Override
    public HotelDTO getHotel(String id) {
       HotelEntity hotelEntity =  hotelRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Id not found"));

       return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    @Override
    public HttpStatus deleteHotel(String id) {
        HotelEntity hotelEntity = hotelRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id not found"));

        hotelRepository.delete(hotelEntity);

        return HttpStatus.NO_CONTENT;
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        HotelEntity hotelEntity = hotelRepository.findById(hotelDTO.getId())
                .orElseThrow(() -> new RuntimeException("Hotel with ID not found"));

        modelMapper.map(hotelDTO, hotelEntity);
        hotelEntity = hotelRepository.save(hotelEntity);

        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        List<HotelEntity> hotelEntities = hotelRepository.findAll();

        List<HotelDTO> hotelDTOS = hotelEntities.stream().
                map((eachHotelEntity) -> modelMapper.map(eachHotelEntity, HotelDTO.class)).
                collect(Collectors.toList());

        return hotelDTOS;
    }
}
