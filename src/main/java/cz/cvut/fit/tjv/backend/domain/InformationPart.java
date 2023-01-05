package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.net.URI;
import java.sql.Date;

@Entity
public class InformationPart implements CommonEntity<URI> {
    @Id
    private URI uri;
    private Date creationTime;
    private String street;
    private String postalCode;
    private Date moveInDate;
    private Long acreage;

    public InformationPart(URI uri, Date creationTime, String street, String postalCode, Date moveInDate, Long acreage) {
        this.uri = uri;
        this.creationTime = creationTime;
        this.street = street;
        this.postalCode = postalCode;
        this.moveInDate = moveInDate;
        this.acreage = acreage;
    }

    public InformationPart(URI uri) {
        this.uri = uri;
    }

    public InformationPart() {}

    @Override
    public URI getId() {
        return uri;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
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
}
