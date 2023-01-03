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

    public InformationPart() {}

    @Override
    public URI getId() {
        return uri;
    }
}
