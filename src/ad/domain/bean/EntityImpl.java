package ad.domain.bean;

import ad.domain.Entity;

abstract public class EntityImpl implements Entity {
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
