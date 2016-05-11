package models.friends;

import models.abergin.AUser;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Embeddable
public class UserIdFriendId implements Serializable{

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    AUser user;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="FRIEND_ID")
    AUser aFriend;
}
