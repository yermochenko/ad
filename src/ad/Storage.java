package ad;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
	private static Map <Integer, ad.objects.Curriculum> Curriculums=new HashMap<>();
	private static Map <Integer, ad.objects.CurriculumDiscipline> CurriculumDisciplines=new HashMap<>();
	private static Map <Integer, ad.objects.Discipline> Disciplines=new HashMap<>();
	private static Map <Integer, ad.objects.Specialty> Specialties=new HashMap<>();
	static{
		ad.objects.Discipline discipline=new ad.objects.Discipline();
		discipline.setName("Web-программирование");
		discipline.setShortName("WП");
		createDiscipline(discipline);
	}
	
	public static Collection <ad.objects.Curriculum> getAllCurriculums(){
		return Curriculums.values();
	}
	public static Collection <ad.objects.CurriculumDiscipline> getAllCurriculumDisciplines(){
		return CurriculumDisciplines.values();
	}
	public static Collection <ad.objects.Discipline> getAllDisciplines(){
		return Disciplines.values();
	}
	public static Collection <ad.objects.Specialty> getAllSpecialties(){
		return Specialties.values();
	}
	
	public static ad.objects.Curriculum getCurriculumById(Integer Id){
		return Curriculums.get(Id);
	}
	public static ad.objects.CurriculumDiscipline getCurriculumDisciplineById(Integer Id){
		return CurriculumDisciplines.get(Id);
	}
	public static ad.objects.Discipline getDisciplineById(Integer Id){
		return Disciplines.get(Id);
	}
	public static ad.objects.Specialty getSpecialtyById(Integer Id){
		return Specialties.get(Id);
	}
	
	public static void createDiscipline(ad.objects.Discipline Discipline){
		Integer Id=1;
		Set <Integer> ids=Disciplines.keySet();
		if(!ids.isEmpty()){
			Id+=Collections.max(ids);
		}
		Discipline.setId(Id);
		Disciplines.put(Id, Discipline);
	}
}