package repository.useractivities;

import models.abergin.AUser;
import models.useractivities.UserPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Repository
public interface UserPointsRepository extends JpaRepository<UserPoints, Long>{

    UserPoints findByUser(AUser user);
}
