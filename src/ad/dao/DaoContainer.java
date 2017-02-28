package ad.dao;

import java.sql.Connection;

import ad.dao.exception.DaoException;
import ad.domain.Discipline;
import ad.domain.Specialty;
import ad.domain.factory.EntityFactory;

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
