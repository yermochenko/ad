package ad.domain.factory;

import ad.domain.Entity;
import ad.domain.factory.exception.EntityCreateException;

public interface EntityFactory<T extends Entity> {
    T create() throws EntityCreateException;
}
