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
public class UserFriend implements Serializable{


    @EmbeddedId
    private UserIdFriendId userIdFriendId;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

}
