package hotelSaver.com.hotelSaver.model.repositories;

import hotelSaver.com.hotelSaver.model.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAll();

    @Override
    Optional<ClienteEntity> findById(Long documento);

}


