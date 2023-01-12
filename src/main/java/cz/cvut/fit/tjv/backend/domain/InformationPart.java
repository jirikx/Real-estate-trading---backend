package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.*;
import java.net.URI;
import java.sql.Date;

@Entity
public class InformationPart implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uri;
    @OneToOne(mappedBy = "offerInfo")
    private Offer offer;
    private Date creationTime;
    private String street;
    private Long postalCode;
    private Date moveInDate;
    private Long acreage;

    public InformationPart(Offer offer) {
        this.offer = offer;
    }

    public InformationPart(Long uri, Offer offer) {
        this.uri = uri;
        this.offer = offer;
    }

    public InformationPart(Offer offer, Date creationTime, String street, Long postalCode, Date moveInDate, Long acreage) {
        this.offer = offer;
        this.creationTime = creationTime;
        this.street = street;
        this.postalCode = postalCode;
        this.moveInDate = moveInDate;
        this.acreage = acreage;
    }

    public InformationPart(Long uri, Offer offer, Date creationTime, String street, Long postalCode, Date moveInDate, Long acreage) {
        this.uri = uri;
        this.offer = offer;
        this.creationTime = creationTime;
        this.street = street;
        this.postalCode = postalCode;
        this.moveInDate = moveInDate;
        this.acreage = acreage;
    }

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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
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
