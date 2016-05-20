package models.abergin;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_TOKEN", schema = Constants.SCHEMA_NAME_REABTE_ABERGIN)
public class UserToken implements Serializable {

    public UserToken() {
    }

    public UserToken(String tokenId, Long expiryDateTime, AUser user) {
        this.tokenId = tokenId;
        this.expiryDateTime = expiryDateTime;
        this.user = user;
    }

    @Id
    @Column(name = "TOKEN_ID", length = 100)
    private String tokenId;

    @Column(name = "EXPIRY_DATETIME", length = 20)
    private Long expiryDateTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private AUser user;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Long getExpiryDateTime() {
        return expiryDateTime;
    }

    public void setExpiryDateTime(Long expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
    }

    public AUser getUser() {
        return user;
    }

    public void setUser(AUser user) {
        this.user = user;
    }

}
