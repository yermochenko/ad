package ad.dao;

import ad.objects.Specialty;

import java.util.Collection;

public interface SpecialtyDao extends Dao<Specialty> {
    Collection<Specialty> readAll() throws Exception;
}
