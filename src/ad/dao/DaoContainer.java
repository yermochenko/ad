package ad.dao;

import ad.dao.DisciplineDao;
import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.objects.Discipline;
import ad.objects.Specialty;
import ad.objects.factory.EntityFactory;

import java.sql.Connection;

/**
 * Created by HomeInc on 09.12.2016.
 */
public interface DaoContainer {
    Connection getConnection() throws DaoException;

    DisciplineDao getDisciplineDao() throws DaoException;
    EntityFactory<Discipline> getDisciplineFactory();

    SpecialtyDao getSpecialtyDao() throws  DaoException;
    EntityFactory<Specialty> getSpecialtyFactory();

    void close();
}
