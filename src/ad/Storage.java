package ad;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
	private static Map <Integer, ad.objects.Curriculum> curriculums=new HashMap<>();
	private static Map <Integer, ad.objects.CurriculumDiscipline> curriculumDisciplines=new HashMap<>();
	private static Map <Integer, ad.objects.Discipline> disciplines=new HashMap<>();
	private static Map <Integer, ad.objects.Specialty> specialties=new HashMap<>();
	static{
		ad.objects.Discipline discipline=new ad.objects.Discipline();
		discipline.setName("Web-программирование");
		discipline.setShortName("WП");
		createDiscipline(discipline);
	}
	
	public static Collection <ad.objects.Curriculum> getAllCurriculums(){
		return curriculums.values();
	}
	public static Collection <ad.objects.CurriculumDiscipline> getAllCurriculumDisciplines(){
		return curriculumDisciplines.values();
	}
	public static Collection <ad.objects.Discipline> getAllDisciplines(){
		return disciplines.values();
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
	public static ad.objects.Discipline getDisciplineById(Integer id){
		return disciplines.get(id);
	}
	public static ad.objects.Specialty getSpecialtyById(Integer id){
		return specialties.get(id);
	}
	
	public static void createDiscipline(ad.objects.Discipline discipline){
		Integer id=1;
		Set <Integer> ids=disciplines.keySet();
		if(!ids.isEmpty()){
			id+=Collections.max(ids);
		}
		discipline.setId(id);
		disciplines.put(id, discipline);
	}
	public static void deleteDisciplineById(Integer id){
		disciplines.remove(id);
	}
	public static void updateDiscipline(ad.objects.Discipline discipline){
		disciplines.put(discipline.getId(), discipline);
	}
}