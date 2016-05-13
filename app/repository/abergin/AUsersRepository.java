package repository.abergin;

import application.enums.USER_TYPE;
import models.abergin.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AUsersRepository extends JpaRepository<AUser, Long>{

    AUser findByEmailAndPasswordAndUserType(String email, String password, USER_TYPE userType);

    AUser findByEmailAndUserType(String email, USER_TYPE userType);

}
