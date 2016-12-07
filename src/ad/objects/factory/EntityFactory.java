package ad.objects.factory;

import ad.objects.Entity;
import ad.objects.factory.exception.EntityCreateException;

public interface EntityFactory<T extends Entity> {
    T create() throws EntityCreateException;
}