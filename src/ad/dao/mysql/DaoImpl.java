package ad.dao.mysql;

import java.sql.Connection;

import ad.dao.Dao;
import ad.dao.cache.Cache;
import ad.dao.exception.DaoException;
import ad.domain.Entity;

abstract public class DaoImpl<T extends Entity> implements Dao<T> {
    private Connection connection;
    private Cache<T> cache;

    final public T read(Integer id) throws DaoException {
        T entity = cache.get(id);
        if(entity == null) {
            entity = readRaw(id);
            cache.set(entity);
        }
        return entity;
    }

    final public Integer create(T entity) throws DaoException {
        Integer id = createRaw(entity);
        entity.setId(id);
        onCreate(entity);
        return id;
    }

    final public void update(T entity) throws DaoException {
        updateRaw(entity);
        onUpdate(entity);
    }

    final public void delete(Integer id) throws DaoException {
        deleteRaw(id);
        onDelete(id);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Cache<T> getCache() {
        return cache;
    }

    public void setCache(Cache<T> cache) {
        this.cache = cache;
    }

    protected void onCreate(T entity) {}

    protected void onUpdate(T entity) {
        cache.delete(entity.getId());
    }

    protected void onDelete(Integer id) {
        cache.delete(id);
    }

    abstract protected T readRaw(Integer id) throws DaoException;

    abstract protected Integer createRaw(T entity) throws DaoException;

    abstract protected void updateRaw(T entity) throws DaoException;

    abstract protected void deleteRaw(Integer id) throws DaoException;
}
