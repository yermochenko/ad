package ad.dao;

import java.sql.Connection;

import ad.dao.cache.Cache;
import ad.dao.exception.DaoException;
import ad.domain.Discipline;
import ad.domain.Specialty;
import ad.domain.factory.EntityFactory;

public interface DaoContainer {
    Connection getConnection() throws DaoException;

    DisciplineDao getDisciplineDao() throws DaoException;

    EntityFactory<Discipline> getDisciplineFactory();

    Cache<Discipline> getDisciplineCache();

    SpecialtyDao getSpecialtyDao() throws DaoException;

    EntityFactory<Specialty> getSpecialtyFactory() throws DaoException;

    Cache<Specialty> getSpecialtyCache();

    void close();
}
