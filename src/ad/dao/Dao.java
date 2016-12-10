package ad.dao;

import ad.dao.exception.DaoException;
import ad.objects.Entity;

public interface Dao <T extends Entity> {
	T read(int id) throws DaoException;
	int create(T object) throws DaoException;
	void update(T object) throws DaoException;
	void delete(int id) throws DaoException;
}