package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.configurations.mapper.ReservationMapper;
import hotelSaver.com.hotelSaver.model.entities.*;
import hotelSaver.com.hotelSaver.model.repositories.HotelRepository;
import hotelSaver.com.hotelSaver.model.repositories.ReservationRepository;
import hotelSaver.com.hotelSaver.model.repositories.UserRepository;
import hotelSaver.com.hotelSaver.service.interfaces.ReservationService;

import hotelSaver.com.hotelSaver.web.dto.ReservationDTO;
import hotelSaver.com.hotelSaver.web.exceptions.types.BadRequestException;
import hotelSaver.com.hotelSaver.web.exceptions.types.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        if((reservationDTO.getReservationID().getUserID().getDocumento() == null)
        || (reservationDTO.getReservationID().getHotelID() == null)){
            throw new BadRequestException("NOT FOUND ID");
        }

        ReservationEntity reservationEntity = reservationMapper.toReservationEntity(reservationDTO);

        reservationRepository.save(reservationEntity);

        return reservationMapper.toReservationDTO(reservationEntity);
    }

    @Override
    public ReservationDTO getReservation(Long documento, String tipoDocumento, String hotelID) {
        UserID userID = new UserID(documento, tipoDocumento);
        ReservationID reservationID = new ReservationID(userID, hotelID);

        ReservationEntity reservationEntity =  reservationRepository.findById(reservationID).
                orElseThrow(() -> new NotFoundException("id not found!!"));

        return reservationMapper.toReservationDTO(reservationEntity);
    }

    @Override
    public HttpStatus deleteReservation(Long documento, String tipoDocumento, String hotelID) {
        UserID userID = new UserID(documento, tipoDocumento);
        ReservationID reservationID = new ReservationID(userID, hotelID);

        ReservationEntity reservationEntity = reservationRepository.findById(reservationID)
                .orElseThrow(() -> new NotFoundException("Reservation not found!"));

        reservationRepository.delete(reservationEntity);

        return HttpStatus.NO_CONTENT;
    }

    @Override
    public ReservationDTO updateReservation(ReservationDTO reservationDTO) {
        ReservationID reservationID = new ReservationID(
                new UserID(reservationDTO.getDocumento(), reservationDTO.getTipoDocumento()),
                reservationDTO.getHotelID()
        );

        ReservationEntity reservationEntity = reservationRepository.findById(reservationID)
                .orElseThrow(() -> new NotFoundException("Reservation not found!"));

        ReservationEntity updatedReservation =
                reservationRepository.save(reservationMapper.toReservationEntity(reservationDTO));

        return reservationMapper.toReservationDTO(updatedReservation);
    }

    @Override
    public List<ReservationDTO> findAllByHotelID(String hotelID) {
        List<ReservationEntity> entities = reservationRepository.findAllByHotelEntity_Id(hotelID);

        return entities.stream().
                map((eachEntity) -> reservationMapper.toReservationDTO(eachEntity)).collect(Collectors.toList());
    }

    @Override
    public List<ReservationDTO> findAllByUserDocumento(Long documento) {
        List<ReservationEntity> entities = reservationRepository.findAllByUserEntityDocumento(documento);

        return entities.stream().map((eachEntitiy) -> reservationMapper.toReservationDTO(eachEntitiy)).collect(Collectors.toList());
    }
}
