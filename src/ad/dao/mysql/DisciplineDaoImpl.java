package ad.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

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
	protected Discipline readRaw(int id) throws DaoException {
		String sql = "SELECT id, name, shortname FROM disciplines WHERE id = ?";
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			Discipline discipline = null;
			if (r.next()) {
				discipline = disciplineFactory.create();
				discipline.setId(r.getInt("id"));
				discipline.setName(r.getString("name"));
				discipline.setShortName(r.getString("shortname"));
			}
			return discipline;
		}catch(SQLException | EntityCreateException e) {
            throw new DaoException(e);
		} finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	@Override
	protected int createRaw(Discipline discipline) throws DaoException {
		String sql = "INSERT INTO disciplines (name, shortname) VALUES (?, ?)";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c=getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, discipline.getName());
			s.setString(2, discipline.getShortName());
			s.executeUpdate();
		}catch(SQLException e) {
            throw new DaoException(e);
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
		return 1;
	}

	@Override
	protected void updateRaw(Discipline discipline) throws DaoException {
		String sql = "UPDATE disciplines SET name = ?, shortname = ? WHERE id = ?";
		Connection c=null;
		PreparedStatement s = null;
		try {
			c=getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, discipline.getName());
			s.setString(2, discipline.getShortName());
			s.setInt(3, discipline.getId());
			s.executeUpdate();
		}catch(SQLException e) {
            throw new DaoException(e);
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	@Override
	protected void deleteRaw(int id) throws DaoException {
		String sql = "DELETE FROM disciplines WHERE id=?";
		Connection c=null;
		PreparedStatement s = null;
		try {
			c=getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			s.executeUpdate();
		} catch(SQLException e) {
            throw new DaoException(e);
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	public Collection<Discipline> readAll() throws DaoException {
		String sql = "SELECT id, name, shortname FROM disciplines";
		Connection c=null;
		Statement s = null;
		ResultSet r = null;
		try {
			c=getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			Collection<Discipline> disciplines = new ArrayList<>();
			while (r.next()) {
				Discipline discipline = disciplineFactory.create();
				discipline.setId(r.getInt("id"));
				discipline.setName(r.getString("name"));
				discipline.setShortName(r.getString("shortname"));
				disciplines.add(discipline);
			}
			return disciplines;
		}catch(SQLException | EntityCreateException e) {
            throw new DaoException(e);
		}  finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
}
