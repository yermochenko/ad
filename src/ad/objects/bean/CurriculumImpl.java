package ad.objects.bean;

import java.util.List;

import ad.objects.Curriculum;
import ad.objects.CurriculumDiscipline;
import ad.objects.Specialty;
/*
* Учебные планы
* List <CurriculumDisciplineImpl> curriculumDisciplineImpls - список дисциплин
* */
public class CurriculumImpl implements Curriculum {
	private Integer id;
	private Specialty specialty;
	private Integer year;
	private List <CurriculumDiscipline> curriculumDisciplines;

	public CurriculumImpl(Specialty specialty, Integer year){
		this.specialty = specialty;
		this.year = year;
	}


	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getYear(){
		return year;
	}
	public void setYear(Integer year){
		this.year=year;
	}
	
	public Specialty getSpecialty(){
		return specialty;
	}
	public void setSpecialty(Specialty specialty){
		this.specialty = specialty;
	}
	
	public List <CurriculumDiscipline> getAllCurriculumDisciplines(){
		return curriculumDisciplines;
	}
	public void addCurriculumDiscipline(CurriculumDiscipline curriculumDiscipline){
		curriculumDisciplines.add(curriculumDiscipline);
	}
	public void deleteCurriculumDisciplineById(Integer id){
		for(CurriculumDiscipline curriculumDiscipline : curriculumDisciplines){
			if(curriculumDiscipline.getId()==id){
				curriculumDisciplines.remove(curriculumDiscipline);
				break;
			}
		}
	}
}