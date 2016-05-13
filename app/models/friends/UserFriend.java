package models.friends;

import application.enums.STATUS;
import models.Constants;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Entity
@Table(name = "USER_FRIENDS", schema = Constants.SCHEMA_NAME_REABTE_FRIENDS)
public class UserFriend implements Serializable {


    @EmbeddedId
    private UserIdFriendId userIdFriendId;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;


    @Override
    public boolean equals(Object thatObject) {

        if (thatObject == null || thatObject.getClass() != getClass())
            return false;

        UserFriend thatUserFriend = (UserFriend) thatObject;

        return (userIdFriendId.user.getUserId().equals(thatUserFriend.userIdFriendId.user.getUserId()) &&
                userIdFriendId.aFriend.getUserId().equals(thatUserFriend.userIdFriendId.aFriend.getUserId())) ||
                (userIdFriendId.user.getUserId().equals(thatUserFriend.userIdFriendId.aFriend.getUserId()) &&
                        userIdFriendId.aFriend.getUserId().equals(thatUserFriend.userIdFriendId.user.getUserId()));
    }

    @Override
    public int hashCode() {
        int userIdHashCode = userIdFriendId.user.getUserId().hashCode();
        int friendHashCode = userIdFriendId.aFriend.getUserId().hashCode();
        return userIdHashCode + friendHashCode;
    }
}
