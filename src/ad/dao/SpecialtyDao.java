package ad.dao;

import java.util.Collection;

import ad.dao.exception.DaoException;
import ad.objects.Specialty;

public interface SpecialtyDao extends Dao<Specialty> {
    Collection<Specialty> readAll() throws DaoException;
}
