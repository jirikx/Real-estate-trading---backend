package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class SupplyOffer extends Offer{
}
