package ad.dao;

import java.util.List;

import ad.dao.exception.DaoException;
import ad.domain.Discipline;

public interface DisciplineDao extends Dao<Discipline> {
    List<Discipline> readAll() throws DaoException;
}
