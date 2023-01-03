package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class DemandOffer extends Offer{
}
