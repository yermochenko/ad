package ad.dao.cache;

import java.util.Map;

import ad.domain.Entity;

public class MapCacheImpl<T extends Entity> implements Cache<T> {
    private Map<Integer, T> cache;

    public void setCache(Map<Integer, T> cache) {
        this.cache = cache;
    }

    @Override
    public T get(Integer id) {
        return cache.get(id);
    }

    @Override
    public void set(T entity) {
        cache.put(entity.getId(), entity);
    }

    @Override
    public void delete(Integer id) {
        cache.remove(id);
    }

    @Override
    public void clear() {
        cache.clear();
    }
}
