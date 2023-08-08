package hotelSaver.com.hotelSaver.model.repositories;

import hotelSaver.com.hotelSaver.model.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<HotelEntity, String> {
    @Override
    List<HotelEntity> findAll();

    @Override
    Optional<HotelEntity> findById(String id);
    Optional<HotelEntity> findByCorreo(String correo);
}
