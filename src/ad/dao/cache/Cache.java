package ad.dao.cache;

import ad.domain.Entity;

public interface Cache<T extends Entity> {
    T get(Integer id);

    void set(T entity);

    void delete(Integer id);

    void clear();
}
