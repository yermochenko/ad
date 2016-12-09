package ad.dao;

import ad.dao.exception.DaoException;
import ad.objects.Specialty;
import ad.objects.bean.SpecialtyImpl;

import java.util.Collection;

public interface SpecialtyDao extends Dao<Specialty> {
    Collection<Specialty> readAll() throws DaoException;
}
