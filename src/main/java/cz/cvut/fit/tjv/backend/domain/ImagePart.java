package cz.cvut.fit.tjv.backend.domain;

import java.net.URI;
import java.sql.Date;

public class ImagePart extends InformationPart {
    private Long width;
    private Long height;
    private String altText;

    public ImagePart(URI uri, Date creationTime, String street, String postalCode, Date moveInDate, Long acreage, Long width, Long height, String altText) {
        super(uri, creationTime, street, postalCode, moveInDate, acreage);
        this.width = width;
        this.height = height;
        this.altText = altText;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }
}