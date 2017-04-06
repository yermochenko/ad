package ad.domain.proxy;

import ad.domain.Entity;

abstract public class BaseProxy<T extends Entity> implements Entity {
    private T entity;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    @Override
    public Integer getId() {
        return entity.getId();
    }

    @Override
    public void setId(Integer id) {
        entity.setId(id);
    }
}
