package ad.dao;

import ad.dao.exception.DaoException;
import ad.objects.bean.SpecialtyImpl;

import java.util.Collection;

public interface SpecialtyDao extends Dao<SpecialtyImpl> {
    Collection<SpecialtyImpl> readAll() throws DaoException;
}
