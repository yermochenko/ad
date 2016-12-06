package ad.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ad.dao.DisciplineDao;
import ad.objects.bean.DisciplineImpl;

public class DisciplineDaoImpl extends BasicStorage implements DisciplineDao {
	public DisciplineImpl read(int id) throws SQLException{
		String sql = "SELECT id, name, shortname FROM disciplines WHERE id = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = connection.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			DisciplineImpl disciplineImpl = null;
			if (r.next()) {
				disciplineImpl = new DisciplineImpl();
				disciplineImpl.setId(r.getInt("id"));
				disciplineImpl.setName(r.getString("name"));
				disciplineImpl.setShortName(r.getString("shortname"));
			}
			return disciplineImpl;
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
	
	public int create(DisciplineImpl disciplineImpl) throws SQLException{
		String sql = "INSERT INTO disciplines (name, shortname) VALUES (?, ?)";
		PreparedStatement s = null;
		try {
			s = connection.prepareStatement(sql);
			s.setString(1, disciplineImpl.getName());
			s.setString(2, disciplineImpl.getShortName());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
		return 1;
	}
	
	public void update(DisciplineImpl disciplineImpl) throws SQLException{
		String sql = "UPDATE disciplines SET name = ?, shortname = ? WHERE id = ?";
		PreparedStatement s = null;
		try {
			s = connection.prepareStatement(sql);
			s.setString(1, disciplineImpl.getName());
			s.setString(2, disciplineImpl.getShortName());
			s.setInt(3, disciplineImpl.getId());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	
	public void delete(int id) throws SQLException{
		String sql = "DELETE FROM disciplines WHERE id=?";
		PreparedStatement s = null;
		try {
			s = connection.prepareStatement(sql);
			s.setInt(1, id);
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	
	public Collection <DisciplineImpl> readAll() throws SQLException{
		String sql = "SELECT id, name, shortname FROM disciplines";
		Statement s = null;
		ResultSet r = null;
		try {
			s = connection.createStatement();
			r = s.executeQuery(sql);
			Collection<DisciplineImpl> disciplineImpls = new ArrayList<>();
			while (r.next()) {
				DisciplineImpl disciplineImpl =new DisciplineImpl();
				disciplineImpl.setId(r.getInt("id"));
				disciplineImpl.setName(r.getString("name"));
				disciplineImpl.setShortName(r.getString("shortname"));
				disciplineImpls.add(disciplineImpl);
			}
			return disciplineImpls;
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
}
