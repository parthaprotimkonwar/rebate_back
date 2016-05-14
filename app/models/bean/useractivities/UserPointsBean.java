package models.bean.useractivities;

import java.io.Serializable;

/**
 * Created by pkonwar on 5/14/2016.
 */
public class UserPointsBean implements Serializable{

    private Long userId;
    private Integer points;


    public UserPointsBean() {
    }

    public UserPointsBean(Long userId, Integer points) {
        this.userId = userId;
        this.points = points;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
