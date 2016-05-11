package repository.useractivities;

import models.useractivities.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransaction, Long> {


}
