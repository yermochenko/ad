package ad.dao;

import java.util.List;

import ad.dao.exception.DaoException;
import ad.domain.Specialty;

public interface SpecialtyDao extends Dao<Specialty> {
    List<Specialty> readAll() throws DaoException;

    List<Specialty> readByParent(Integer parentId) throws DaoException;
}
