package repository.friends;

import models.friends.UserFriend;
import models.friends.UserIdFriendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, UserIdFriendId>{
}
