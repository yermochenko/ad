package ad.dao;

import java.util.Collection;

import ad.dao.exception.DaoException;
import ad.objects.Discipline;

public interface DisciplineDao extends Dao<Discipline> {
	Collection <Discipline> readAll() throws DaoException;
}
