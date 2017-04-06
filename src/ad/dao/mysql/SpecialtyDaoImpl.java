package ad.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.domain.Specialty;
import ad.domain.factory.exception.EntityCreateException;

public class SpecialtyDaoImpl extends DaoImpl<Specialty> implements SpecialtyDao {
    @Override
    protected Integer createRaw(Specialty specialty) throws DaoException {
        String sql = "INSERT INTO `specialties` (`code`, `name`, `parent_id`, `qualification`, `shortname`) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, specialty.getCode());
            statement.setString(2, specialty.getName());
            if(specialty.getParent() != null) {
                statement.setInt(3, specialty.getParent().getId());
            } else {
                statement.setNull(3, Types.INTEGER);
            }
            statement.setString(4, specialty.getQualification());
            statement.setString(5, specialty.getShortName());
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
    protected void deleteRaw(Integer id) throws DaoException {
        String sql = "DELETE FROM `specialties` WHERE `id` = ?";
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

    @Override
    protected void updateRaw(Specialty specialty) throws DaoException {
        String sql = "UPDATE `specialties` SET `code` = ?, `name` = ?, `parent_id` = ?, `qualification` = ?, `shortname` = ? WHERE `id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, specialty.getCode());
            statement.setString(2, specialty.getName());
            if(specialty.getParent() != null) {
                statement.setInt(3, specialty.getParent().getId());
            } else {
                statement.setNull(3, Types.INTEGER);
            }
            statement.setString(4, specialty.getQualification());
            statement.setString(5, specialty.getShortName());
            statement.setInt(6, specialty.getId());
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
    protected Specialty readRaw(Integer id) throws DaoException {
        String sql = "SELECT `code`, `name`, `parent_id`, `qualification`, `shortname` FROM `specialties` WHERE `id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Specialty specialty = null;
            if(resultSet.next()) {
                specialty = getEntityFactory().create();
                specialty.setId(id);
                specialty.setCode(resultSet.getString("code"));
                specialty.setName(resultSet.getString("name"));
                Integer parentId = resultSet.getInt("parent_id");
                if(!resultSet.wasNull()) {
                    specialty.getParent().setId(parentId);
                }
                specialty.setQualification(resultSet.getString("qualification"));
                specialty.setShortName(resultSet.getString("shortname"));
            }
            return specialty;
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

    public List<Specialty> readAll() throws DaoException {
        String sql = "SELECT `id`, `code`, `name`, `parent_id`, `qualification`, `shortname` FROM `specialties`";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            List<Specialty> specialties = new ArrayList<>();
            while(resultSet.next()) {
                Specialty specialty = getEntityFactory().create();
                specialty.setId(resultSet.getInt("id"));
                specialty.setCode(resultSet.getString("code"));
                specialty.setName(resultSet.getString("name"));
                Integer parentId = resultSet.getInt("parent_id");
                if(!resultSet.wasNull()) {
                    specialty.getParent().setId(parentId);
                }
                specialty.setQualification(resultSet.getString("qualification"));
                specialty.setShortName(resultSet.getString("shortname"));
                specialties.add(specialty);
            }
            return specialties;
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
