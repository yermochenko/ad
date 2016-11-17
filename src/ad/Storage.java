package ad;

import ad.objects.Discipline;
import ad.objects.Specialty;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
	private static String jdbcUrl = null;
	private static String jdbcUser = null;
	private static String jdbcPassword = null;
	
	private static Map <Integer, ad.objects.Curriculum> curriculums=new HashMap<>();
	private static Map <Integer, ad.objects.CurriculumDiscipline> curriculumDisciplines=new HashMap<>();
	
	public static void init(String jdbcDriver, String jdbcUrl, String jdbcUser, String jdbcPassword) throws ClassNotFoundException {
		Class.forName(jdbcDriver);
		Storage.jdbcUrl = jdbcUrl;
		Storage.jdbcUser = jdbcUser;
		Storage.jdbcPassword = jdbcPassword;
	}	
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	}

	static{

	}

	public static void createDiscipline(Discipline discipline) throws SQLException{
		String sql = "INSERT INTO disciplines (name, shortname) VALUES (?, ?)";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, discipline.getName());
			s.setString(2, discipline.getShortName());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	public static void deleteDisciplineById(Integer id) throws SQLException{
		String sql = "DELETE FROM disciplines WHERE id=?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	public static void updateDiscipline(Discipline discipline) throws SQLException{
		String sql = "UPDATE disciplines SET name = ?, shortname = ? WHERE id = ?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, discipline.getName());
			s.setString(2, discipline.getShortName());
			s.setInt(3, discipline.getId());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	public static Discipline getDisciplineById(Integer id) throws SQLException{
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
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	public static Collection <Discipline> getAllDisciplines() throws SQLException{
		String sql = "SELECT id, name, shortname FROM disciplines";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.createStatement();
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
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}

		}
	}

	public static void createSpecialty(ad.objects.Specialty specialty) throws SQLException {
		String sql = "INSERT INTO specialties (code, name, parent_id, qualification, shortname, specialty_direction) VALUES (?, ?, ?, ?, ?, ?)";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, specialty.getCode());
			s.setString(2,specialty.getName());
			System.out.println("========================== parent id = " + specialty.getParentId());
			if(specialty.getParentId()==0){
				s.setString(3,null);
			}else{
				s.setInt(3,specialty.getParentId());
			}
			s.setString(4,specialty.getQualification());
			s.setString(5, specialty.getShortName());
			s.setString(6, specialty.getSpecialtyDirection());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
				System.out.println("nullpointer =========================================");
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
				System.out.println("nullpointer =========================================");
			}
		}
	}
	public static void deleteSpecialtyById(Integer id) throws SQLException {
		String sql = "DELETE FROM specialties WHERE id=?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}

		//specialties.remove(id);
	}
	public static void updateSpecialty(ad.objects.Specialty specialty) throws SQLException {
		String sql = "UPDATE specialties SET code = ?, id = ?, name = ?, parent_id = ?, qualification = ?, shortname = ?, specialty_direction = ? WHERE id = ?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, specialty.getCode());
			s.setInt(2, specialty.getId());
			s.setString(3,specialty.getName());
			if(specialty.getParentId()==0){
				s.setString(4,null);
				s.setNull(4, Types.INTEGER);
			}else{
				s.setInt(4,specialty.getParentId());
			}
			s.setString(5,specialty.getQualification());
			s.setString(6, specialty.getShortName());
			s.setString(7, specialty.getSpecialtyDirection());
			s.setInt(8, specialty.getId());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}

		//specialties.put(specialty.getId(), specialty);
	}
	public static ad.objects.Specialty getSpecialtyById(Integer id) throws SQLException {
		String sql = "SELECT  id, code, name, parent_id, qualification, shortname, specialty_direction FROM specialties WHERE id = ?";
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			Specialty specialty = null;
			if (r.next()) {
				specialty = new Specialty();
				specialty.setId(r.getInt("id"));
				specialty.setCode(r.getString("code"));
				specialty.setName(r.getString("name"));
				specialty.setParent(getSpecialtyById(r.getInt("parent_id")));
				specialty.setParentId(r.getInt("parent_id"));
				specialty.setQualification(r.getString("qualification"));
				specialty.setShortName(r.getString("shortname"));
				specialty.setSpecialtyDirection(r.getString("specialty_direction"));
			}
			return specialty;
		} finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}

		//return specialties.get(id);
	}
	public static Collection <ad.objects.Specialty> getAllSpecialties() throws SQLException {
		String sql = "SELECT  id, code, name, parent_id, qualification, shortname, specialty_direction FROM specialties";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			Collection<Specialty> specialties = new ArrayList<>();
			while (r.next()) {
				Specialty specialty=new Specialty();
				specialty.setId(r.getInt("id"));
				specialty.setCode(r.getString("code"));
				specialty.setName(r.getString("name"));
				specialty.setParent(getSpecialtyById(r.getInt("parent_id")));
				specialty.setParentId(r.getInt("parent_id"));
				specialty.setQualification(r.getString("qualification"));
				specialty.setShortName(r.getString("shortname"));
				specialty.setSpecialtyDirection(r.getString("specialty_direction"));
				specialties.add(specialty);
			}
			return specialties;
		} finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}

		}

		//return specialties.values();
	}

	public static ad.objects.Curriculum getCurriculumById(Integer id){
		return curriculums.get(id);
	}
	public static ad.objects.CurriculumDiscipline getCurriculumDisciplineById(Integer id){
		return curriculumDisciplines.get(id);
	}

	public static Collection <ad.objects.Curriculum> getAllCurriculums(){
		return curriculums.values();
	}
	public static Collection <ad.objects.CurriculumDiscipline> getAllCurriculumDisciplines(){
		return curriculumDisciplines.values();
	}
}