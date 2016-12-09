package ad.dao;

import ad.dao.exception.DaoException;
import ad.dao.mysql.Connector;
import ad.dao.mysql.DisciplineDaoImpl;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.objects.Discipline;
import ad.objects.Specialty;
import ad.objects.bean.DisciplineImpl;
import ad.objects.bean.SpecialtyImpl;
import ad.objects.factory.EntityFactory;
import ad.objects.factory.SimpleEntityFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by HomeInc on 09.12.2016.
 */
public class DaoContainerImpl implements DaoContainer {
    private Connection connection = null;
    private DisciplineDao disciplineDao = null;
    private EntityFactory<Discipline> disciplineFactory = null;
    private SpecialtyDao specialtyDao = null;
    private EntityFactory<Specialty> specialtyFactory = null;

    @Override
    public Connection getConnection() throws DaoException {
        if(connection == null){
            try{
                connection = Connector.getConnection();
            } catch (SQLException e){
                throw new DaoException(e);
            }
        }
        return connection;
    }

    @Override
    public DisciplineDao getDisciplineDao() throws DaoException {
        if(disciplineDao ==null){
            DisciplineDaoImpl disciplineDaoImpl = new DisciplineDaoImpl();
            disciplineDaoImpl.setConnection(getConnection());
            disciplineDaoImpl.setDisciplineFactory(getDisciplineFactory());
            disciplineDao = disciplineDaoImpl;
        }
        return disciplineDao;
    }

    @Override
    public EntityFactory<Discipline> getDisciplineFactory() {
        if(disciplineFactory == null){
            SimpleEntityFactory<Discipline> simpleDisciplineFactory = new SimpleEntityFactory<>();
            simpleDisciplineFactory.setEntityClass(DisciplineImpl.class);
            disciplineFactory = simpleDisciplineFactory;
        }
        return disciplineFactory;
    }

    @Override
    public SpecialtyDao getSpecialtyDao() throws DaoException {
        if(specialtyDao ==null){
            SpecialtyDaoImpl specialtyDaoImpl = new SpecialtyDaoImpl();
            specialtyDaoImpl.setConnection(getConnection());
            specialtyDaoImpl.setSpecialtyFactory(getSpecialtyFactory());
            specialtyDao = specialtyDaoImpl;
        }
        return specialtyDao;
    }

    @Override
    public EntityFactory<Specialty> getSpecialtyFactory() {
        if(specialtyFactory == null){
            SimpleEntityFactory<Specialty> simpleDisciplineFactory = new SimpleEntityFactory<>();
            simpleDisciplineFactory.setEntityClass(SpecialtyImpl.class);
            specialtyFactory = simpleDisciplineFactory;
        }
        return specialtyFactory;
    }

    @Override
    public void close() {
        try{
            connection.close();
        } catch (NullPointerException | SQLException e) {
        }
    }
}
