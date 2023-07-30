package hotelSaver.com.hotelSaver.model.repositories;

import hotelSaver.com.hotelSaver.model.entities.ReservationEntity;
import hotelSaver.com.hotelSaver.model.entities.ReservationID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationEntity, ReservationID> {
    Optional<ReservationEntity> findById(ReservationID reservationID);
}
