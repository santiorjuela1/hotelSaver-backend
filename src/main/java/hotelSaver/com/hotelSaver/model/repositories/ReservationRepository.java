package hotelSaver.com.hotelSaver.model.repositories;

import hotelSaver.com.hotelSaver.model.entities.ReservationEntity;
import hotelSaver.com.hotelSaver.model.entities.ReservationID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationEntity, ReservationID> {
    Optional<ReservationEntity> findById(ReservationID reservationID);

    List<ReservationEntity> findAllByHotelEntity_Id(String hotelID);

    @Query(value = "SELECT * FROM ReservationEntity r WHERE documento_user = :documento", nativeQuery = true)
    List<ReservationEntity> findAllByUserEntityDocumento(@Param("documento")Long documento);

}
