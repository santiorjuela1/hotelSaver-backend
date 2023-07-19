package hotelSaver.com.hotelSaver.model.repositories;

import hotelSaver.com.hotelSaver.model.entities.UserEntity;
import hotelSaver.com.hotelSaver.model.entities.UserID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UserID> {
    @Override
    Optional<UserEntity> findById(UserID userID);

}
