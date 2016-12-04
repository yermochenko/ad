package ad.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ad.dao.DisciplineDao;
import ad.objects.Discipline;

public class DisciplineDaoImpl extends BasicStorage implements DisciplineDao {
	public Discipline read(int id) throws SQLException{
		String sql = "SELECT id, name, shortname FROM disciplines WHERE id = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = connection.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			Discipline discipline = null;
			if (r.next()) {
				discipline = new Discipline();
				discipline.setId(r.getInt("id"));
				discipline.setName(r.getString("name"));
				discipline.setShortName(r.getString("shortname"));
			}
			return discipline;
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
	
	public int create(Discipline discipline) throws SQLException{
		String sql = "INSERT INTO disciplines (name, shortname) VALUES (?, ?)";
		PreparedStatement s = null;
		try {
			s = connection.prepareStatement(sql);
			s.setString(1, discipline.getName());
			s.setString(2, discipline.getShortName());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
		return 1;
	}
	
	public void update(Discipline discipline) throws SQLException{
		String sql = "UPDATE disciplines SET name = ?, shortname = ? WHERE id = ?";
		PreparedStatement s = null;
		try {
			s = connection.prepareStatement(sql);
			s.setString(1, discipline.getName());
			s.setString(2, discipline.getShortName());
			s.setInt(3, discipline.getId());
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
	
	public Collection <Discipline> readAll() throws SQLException{
		String sql = "SELECT id, name, shortname FROM disciplines";
		Statement s = null;
		ResultSet r = null;
		try {
			s = connection.createStatement();
			r = s.executeQuery(sql);
			Collection<Discipline> disciplines = new ArrayList<>();
			while (r.next()) {
				Discipline discipline=new Discipline();
				discipline.setId(r.getInt("id"));
				discipline.setName(r.getString("name"));
				discipline.setShortName(r.getString("shortname"));
				disciplines.add(discipline);
			}
			return disciplines;
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
