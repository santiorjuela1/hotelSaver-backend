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

    // works
    @Query(value="SELECT * FROM RESERVATIONS WHERE hotel_id =:hotelID", nativeQuery = true)
    List<ReservationEntity> findAllByHotelEntity_Id(@Param("hotelID")String hotelID);


    @Query(value = "SELECT * FROM RESERVATIONS WHERE documento_user = :documento", nativeQuery = true)
    List<ReservationEntity> findAllByUserEntityDocumento(@Param("documento")Long documento);

}
