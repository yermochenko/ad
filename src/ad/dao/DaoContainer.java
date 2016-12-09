package ad.dao;

import ad.dao.exception.DaoException;
import ad.objects.Discipline;
import ad.objects.factory.EntityFactory;

import java.sql.Connection;

/**
 * Created by HomeInc on 09.12.2016.
 */
public interface DaoContainer {
    Connection getConnection() throws DaoException;
    DisciplineDao getDisciplineDao() throws DaoException;
    EntityFactory<Discipline> getDisciplineFactory();
    void close();
}
