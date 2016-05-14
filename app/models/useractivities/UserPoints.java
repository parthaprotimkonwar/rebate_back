package models.useractivities;

import models.Constants;
import models.abergin.AUser;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 5/11/2016.
 */
@Entity
@Table(name = "USER_POINTS", schema = Constants.SCHEMA_NAME_REABTE_POINTS)
public class UserPoints implements Serializable{

    @Id
    @Column(name = "USER_POINTS_ID")
    private Long userPointsId;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    private AUser user;

    @Column(name = "POINTS")
    private Integer points;

    public AUser getUser() {
        return user;
    }

    public void setUser(AUser user) {
        this.user = user;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getUserPointsId() {
        return userPointsId;
    }

    public void setUserPointsId(Long userPointsId) {
        this.userPointsId = userPointsId;
    }
}
