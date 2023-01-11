package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URI;
import java.sql.Date;

@Entity
public class InformationPart implements CommonEntity<Long> {
    @Id
    private Long uri;
    private Long offerId;
    private Date creationTime;
    private String street;
    private Long postalCode;
    private Date moveInDate;
    private Long acreage;

    public InformationPart(Long uri, Date creationTime, String street, Long postalCode, Date moveInDate, Long acreage) {
        this.uri = uri;
        this.creationTime = creationTime;
        this.street = street;
        this.postalCode = postalCode;
        this.moveInDate = moveInDate;
        this.acreage = acreage;
    }

    public InformationPart(Long uri) {
        this.uri = uri;
    }

    public InformationPart() {}

    @Override
    public Long getId() {
        return uri;
    }

    public Long getUri() {
        return uri;
    }

    public void setUri(Long uri) {
        this.uri = uri;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Long getAcreage() {
        return acreage;
    }

    public void setAcreage(Long acreage) {
        this.acreage = acreage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InformationPart info = (InformationPart) o;

        return getId() != null ? getId().equals(info.getId()) : info.getId() == null;
    }

    @Override
    public int hashCode() {
        return uri.hashCode();
    }
}
