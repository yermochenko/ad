package ad.dao;

import ad.objects.bean.SpecialtyImpl;

import java.util.Collection;

public interface SpecialtyDao extends Dao<SpecialtyImpl> {
    Collection<SpecialtyImpl> readAll() throws Exception;
}
