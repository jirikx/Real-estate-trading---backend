package cz.cvut.fit.tjv.backend.domain;

import java.io.Serializable;

public interface CommonEntity<ID> extends Serializable {
    ID getId();
}
