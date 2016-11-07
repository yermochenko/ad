package ad;

import ad.objects.Discipline;
import ad.objects.Specialty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	private static Map <Integer, ad.objects.Specialty> specialties=new HashMap<>();
	
	public static void init(String jdbcDriver, String jdbcUrl, String jdbcUser, String jdbcPassword)
			throws ClassNotFoundException {
		Class.forName(jdbcDriver);
		Storage.jdbcUrl = jdbcUrl;
		Storage.jdbcUser = jdbcUser;
		Storage.jdbcPassword = jdbcPassword;
	}
	
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	}
	
	static{
		Specialty specialty = new Specialty("P","Программное обеспечение компьютерных систем","ПОКС","квалификация","направление",new Specialty());
		createSpecialty(specialty);
	}
	
	public static Collection <ad.objects.Curriculum> getAllCurriculums(){
		return curriculums.values();
	}
	public static Collection <ad.objects.CurriculumDiscipline> getAllCurriculumDisciplines(){
		return curriculumDisciplines.values();
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
	public static Collection <ad.objects.Specialty> getAllSpecialties(){
		return specialties.values();
	}
	
	public static ad.objects.Curriculum getCurriculumById(Integer id){
		return curriculums.get(id);
	}
	public static ad.objects.CurriculumDiscipline getCurriculumDisciplineById(Integer id){
		return curriculumDisciplines.get(id);
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
	public static ad.objects.Specialty getSpecialtyById(Integer id){
		return specialties.get(id);
	}

	public static void createSpecialty(ad.objects.Specialty specialty){
		Integer id=1;
		Set <Integer> ids=specialties.keySet();
		if(!ids.isEmpty()){
			id+=Collections.max(ids);
		}
		specialty.setId(id);
		specialties.put(id, specialty);
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
	public static void deleteSpecialtyById(Integer id){
		specialties.remove(id);
	}
	public static void updateSpecialty(ad.objects.Specialty specialty){
		specialties.put(specialty.getId(), specialty);
	}
}