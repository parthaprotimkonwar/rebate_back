package repository.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.address.UserAddress;
import models.address.UserIdAddressId;

public interface UserAddressRepository extends JpaRepository<UserAddress, UserIdAddressId>{
	
	List<UserAddress> findAllByUserIdAddressIdUserUserId(Long userId);

}
