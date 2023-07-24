package hotelSaver.com.hotelSaver.model.repositories;

import hotelSaver.com.hotelSaver.model.entities.ReservationEntity;
import hotelSaver.com.hotelSaver.model.entities.ReservationID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, ReservationID> {
}
