package ad.dao.mysql;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import ad.dao.Dao;
import ad.dao.exception.DaoException;
import ad.objects.Entity;

abstract public class DaoImpl<T extends Entity> implements Dao<T> {
    protected Connection connection;
    private Map<Integer, T> cache = new HashMap<Integer, T>();
    public T read(int id) throws DaoException {
        T entity = cache.get(id);
        if(entity == null) {
            entity = readRaw(id);
            addToCache(entity);
        }
        return entity;
    }
    public int create(T object) throws DaoException {
        int id = createRaw(object);
        object.setId(id);
        addToCache(object);
        return id;
    }
    public void update(T object) throws DaoException {
        updateRaw(object);
        addToCache(object);
    }
    public void delete(int id) throws DaoException {
        deleteFromCache(id);
        deleteRaw(id);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected void addToCache(T entity) {
        if(entity!=null){
            cache.put(entity.getId(), entity);
        }else{
            System.out.println("Попытка добавить пустой элемент в кэш специальости");
        }

    }
    protected void deleteFromCache(int id) {
        cache.remove(id);
    }
    protected void clearCache() {
        cache.clear();
    }
    abstract protected T readRaw(int id) throws DaoException;
    abstract protected int createRaw(T object) throws DaoException;
    abstract protected void updateRaw(T object) throws DaoException;
    abstract protected void deleteRaw(int id) throws DaoException;
}