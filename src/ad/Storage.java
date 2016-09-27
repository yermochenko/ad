package ad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Storage {
	private static Map <Integer, Curriculum> Curriculums=new HashMap<>();
	private static Map <Integer, CurriculumDiscipline> CurriculumDisciplines=new HashMap<>();
	private static Map <Integer, Discipline> Disciplines=new HashMap<>();
	private static Map <Integer, Specialty> Specialties=new HashMap<>();
	static{
		
	}
	
	public static Collection <Curriculum> getAllCurriculums(){
		return Curriculums.values();
	}
	public static Collection <CurriculumDiscipline> getAllCurriculumDisciplines(){
		return CurriculumDisciplines.values();
	}
	public static Collection <Discipline> getAllDisciplines(){
		return Disciplines.values();
	}
	public static Collection <Specialty> getAllSpecialties(){
		return Specialties.values();
	}
	
	public static Curriculum getCurriculumById(Integer Id){
		return Curriculums.get(Id);
	}
	public static CurriculumDiscipline getCurriculumDisciplineById(Integer Id){
		return CurriculumDisciplines.get(Id);
	}
	public static Discipline getDisciplineById(Integer Id){
		return Disciplines.get(Id);
	}
	public static Specialty getSpecialtyById(Integer Id){
		return Specialties.get(Id);
	}
}