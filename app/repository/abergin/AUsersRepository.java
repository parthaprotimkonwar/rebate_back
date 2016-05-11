package repository.abergin;

import models.abergin.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AUsersRepository extends JpaRepository<AUser, Long>{

    AUser findByEmailAndPassword(String email, String password);

    AUser findByEmail(String email);

}
