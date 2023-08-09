package hotelSaver.com.hotelSaver.service.interfaces;
import hotelSaver.com.hotelSaver.web.dto.HotelDTO;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

public interface HotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);
    HotelDTO getHotel(String id);
    HttpStatus deleteHotel(String id);
    HotelDTO updateHotel(HotelDTO hotelDTO);

    List<HotelDTO> getAllHotels();
    HotelDTO getHotelByCorreo(String correo);
}
