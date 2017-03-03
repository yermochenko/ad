package ad.dao;

import ad.dao.exception.DaoException;
import ad.domain.Entity;

public interface Dao<T extends Entity> {
    T read(Integer id) throws DaoException;

    Integer create(T entity) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(Integer id) throws DaoException;
}
