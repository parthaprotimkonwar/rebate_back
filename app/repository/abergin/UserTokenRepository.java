package repository.abergin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.abergin.UserToken;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, String>{

	UserToken findByUserUserId(Long userId);
}
