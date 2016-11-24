package ad;

import ad.objects.Discipline;
import ad.objects.Specialty;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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