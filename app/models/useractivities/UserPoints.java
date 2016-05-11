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
    public AUser user;

    @Column(name = "POINTS")
    private Integer points;
}
