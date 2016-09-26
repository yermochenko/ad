package ad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Curriculum {
	private Integer Id;
	private Specialty Specialty;
	private Integer Year;
	private Map <Integer, CurriculumDiscipline> CurriculumDisciplines;
	
	public Integer getId(){
		return Id;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	
	public Integer getYear(){
		return Year;
	}
	public void setYear(Integer Year){
		this.Year=Year;
	}
	
	public Specialty getSpecialty(){
		return Specialty;
	}
	public void setSpecialty(Specialty Specialty){
		this.Specialty=Specialty;
	}
	
	public void initialize(){
		if(CurriculumDisciplines!=null){
			CurriculumDisciplines=new HashMap<>();
		}
	}
	public Collection <CurriculumDiscipline> getAllCurriculumDisciplines(){
		return CurriculumDisciplines.values();
	}
	public void addCurriculumDiscipline(CurriculumDiscipline CurriculumDiscipline){
		CurriculumDisciplines.put(CurriculumDiscipline.getId(), CurriculumDiscipline);
	}
	public void deleteCurriculumDisciplineById(Integer Id){
		CurriculumDisciplines.remove(Id);
	}
}