package ad.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ad.dao.DisciplineDao;
import ad.dao.exception.DaoException;
import ad.domain.Discipline;
import ad.domain.factory.EntityFactory;
import ad.domain.factory.exception.EntityCreateException;

public class DisciplineDaoImpl extends DaoImpl<Discipline> implements DisciplineDao {
    private EntityFactory<Discipline> disciplineFactory;

    public void setDisciplineFactory(EntityFactory<Discipline> disciplineFactory) {
        this.disciplineFactory = disciplineFactory;
    }

    @Override
    protected Discipline readRaw(Integer id) throws DaoException {
        String sql = "SELECT `name`, `shortname` FROM `disciplines` WHERE `id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Discipline discipline = null;
            if(resultSet.next()) {
                discipline = disciplineFactory.create();
                discipline.setId(id);
                discipline.setName(resultSet.getString("name"));
                discipline.setShortName(resultSet.getString("shortname"));
            }
            return discipline;
        } catch(SQLException | EntityCreateException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                statement.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    protected Integer createRaw(Discipline discipline) throws DaoException {
        String sql = "INSERT INTO `disciplines` (`name`, `shortname`) VALUES (?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, discipline.getName());
            statement.setString(2, discipline.getShortName());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return null;
            }
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                statement.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    protected void updateRaw(Discipline discipline) throws DaoException {
        String sql = "UPDATE `disciplines` SET `name` = ?, `shortname` = ? WHERE `id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, discipline.getName());
            statement.setString(2, discipline.getShortName());
            statement.setInt(3, discipline.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    protected void deleteRaw(Integer id) throws DaoException {
        String sql = "DELETE FROM `disciplines` WHERE `id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public List<Discipline> readAll() throws DaoException {
        String sql = "SELECT `id`, `name`, `shortname` FROM `disciplines`";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            List<Discipline> disciplines = new ArrayList<>();
            while(resultSet.next()) {
                Discipline discipline = disciplineFactory.create();
                discipline.setId(resultSet.getInt("id"));
                discipline.setName(resultSet.getString("name"));
                discipline.setShortName(resultSet.getString("shortname"));
                disciplines.add(discipline);
            }
            return disciplines;
        } catch(SQLException | EntityCreateException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                statement.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }
}
