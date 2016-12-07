package ad.objects.factory;

import ad.objects.Entity;
import ad.objects.factory.exception.EntityCreateException;

public class SimpleEntityFactory<T extends Entity> implements EntityFactory<T> {
    private Class<?> entityClass;

    public void setEntityClass(Class<? extends T> entityClass) {
        this.entityClass = entityClass;
    }

    @SuppressWarnings("unchecked")
	@Override
    public T create() throws EntityCreateException {
        try {
            return (T)entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new EntityCreateException(e);
        }
    }
}