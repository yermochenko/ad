package ad.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import ad.dao.DaoContainer;
import ad.dao.DisciplineDao;
import ad.dao.SpecialtyDao;
import ad.dao.cache.Cache;
import ad.dao.cache.MapCacheImpl;
import ad.dao.exception.DaoException;
import ad.domain.Discipline;
import ad.domain.Specialty;
import ad.domain.bean.DisciplineImpl;
import ad.domain.bean.SpecialtyImpl;
import ad.domain.factory.EntityFactory;
import ad.domain.factory.SimpleEntityFactory;

public class DaoContainerImpl implements DaoContainer {
    private Connection connection;
    private DisciplineDao disciplineDao;
    private EntityFactory<Discipline> disciplineFactory;
    private Cache<Discipline> disciplineCache;
    private SpecialtyDao specialtyDao;
    private EntityFactory<Specialty> specialtyFactory;
    private Cache<Specialty> specialtyCache;

    @Override
    public Connection getConnection() throws DaoException {
        if(connection == null) {
            try {
                connection = Connector.getConnection();
            } catch(SQLException e) {
                throw new DaoException(e);
            }
        }
        return connection;
    }

    @Override
    public DisciplineDao getDisciplineDao() throws DaoException {
        if(disciplineDao == null) {
            DisciplineDaoImpl disciplineDaoImpl = new DisciplineDaoImpl();
            disciplineDaoImpl.setConnection(getConnection());
            disciplineDaoImpl.setDisciplineFactory(getDisciplineFactory());
            disciplineDaoImpl.setCache(getDisciplineCache());
            disciplineDao = disciplineDaoImpl;
        }
        return disciplineDao;
    }

    @Override
    public EntityFactory<Discipline> getDisciplineFactory() {
        if(disciplineFactory == null) {
            SimpleEntityFactory<Discipline> simpleDisciplineFactory = new SimpleEntityFactory<>();
            simpleDisciplineFactory.setEntityClass(DisciplineImpl.class);
            disciplineFactory = simpleDisciplineFactory;
        }
        return disciplineFactory;
    }

    @Override
    public Cache<Discipline> getDisciplineCache() {
        if(disciplineCache == null) {
            MapCacheImpl<Discipline> cacheImpl = new MapCacheImpl<>();
            cacheImpl.setCache(new HashMap<Integer, Discipline>());
            disciplineCache = cacheImpl;
        }
        return disciplineCache;
    }

    @Override
    public SpecialtyDao getSpecialtyDao() throws DaoException {
        if(specialtyDao == null) {
            SpecialtyDaoImpl specialtyDaoImpl = new SpecialtyDaoImpl();
            specialtyDaoImpl.setConnection(getConnection());
            specialtyDaoImpl.setSpecialtyFactory(getSpecialtyFactory());
            specialtyDaoImpl.setCache(getSpecialtyCache());
            specialtyDao = specialtyDaoImpl;
        }
        return specialtyDao;
    }

    @Override
    public EntityFactory<Specialty> getSpecialtyFactory() {
        if(specialtyFactory == null) {
            SimpleEntityFactory<Specialty> simpleDisciplineFactory = new SimpleEntityFactory<>();
            simpleDisciplineFactory.setEntityClass(SpecialtyImpl.class);
            specialtyFactory = simpleDisciplineFactory;
        }
        return specialtyFactory;
    }

    @Override
    public Cache<Specialty> getSpecialtyCache() {
        if(specialtyCache == null) {
            MapCacheImpl<Specialty> cacheImpl = new MapCacheImpl<>();
            cacheImpl.setCache(new HashMap<Integer, Specialty>());
            specialtyCache = cacheImpl;
        }
        return specialtyCache;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch(NullPointerException | SQLException e) {}
    }
}
