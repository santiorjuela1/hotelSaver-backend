package hotelSaver.com.hotelSaver.model.repositories;

import hotelSaver.com.hotelSaver.model.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClienteEntity, Long> {
}
