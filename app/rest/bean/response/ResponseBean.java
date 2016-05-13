package rest.bean.response;

import application.enums.STATUS;

import java.io.Serializable;

/**
 * Created by pkonwar on 5/13/2016.
 */
public class ResponseBean implements Serializable{
    private STATUS status;

    public ResponseBean() {
        this.status = status;
    }

    public ResponseBean(STATUS status) {
        this.status = status;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
