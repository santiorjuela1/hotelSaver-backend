package hotelSaver.com.hotelSaver.service.interfaces;

import hotelSaver.com.hotelSaver.web.dto.ReservationDTO;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ReservationService {

    ReservationDTO createReservation(ReservationDTO reservationDTO);
    ReservationDTO getReservation(Long documento, String tipoDocumento, String hotelID);
    HttpStatus deleteReservation(Long documento, String tipoDocumento, String hotelID);
    ReservationDTO updateReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> findAllByHotelID(String hotelID);
    List<ReservationDTO> findAllByUserDocumento(Long documento);
}
