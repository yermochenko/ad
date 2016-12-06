package ad.objects.bean;

import ad.objects.Curriculum;

import java.util.List;
/*
* Учебные планы
* List <CurriculumDisciplineImpl> curriculumDisciplineImpls - список дисциплин
* */
public class CurriculumImpl implements Curriculum {
	private Integer id;
	private SpecialtyImpl specialtyImpl;
	private Integer year;
	private List <CurriculumDisciplineImpl> curriculumDisciplineImpls;

	public CurriculumImpl(SpecialtyImpl specialtyImpl, Integer year){
		this.specialtyImpl = specialtyImpl;
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
	
	public SpecialtyImpl getSpecialtyImpl(){
		return specialtyImpl;
	}
	public void setSpecialtyImpl(SpecialtyImpl specialtyImpl){
		this.specialtyImpl = specialtyImpl;
	}
	
	public List <CurriculumDisciplineImpl> getAllCurriculumDisciplines(){
		return curriculumDisciplineImpls;
	}
	public void addCurriculumDiscipline(CurriculumDisciplineImpl curriculumDisciplineImpl){
		curriculumDisciplineImpls.add(curriculumDisciplineImpl);
	}
	public void deleteCurriculumDisciplineById(Integer id){
		for(CurriculumDisciplineImpl curriculumDisciplineImpl : curriculumDisciplineImpls){
			if(curriculumDisciplineImpl.getId()==id){
				curriculumDisciplineImpls.remove(curriculumDisciplineImpl);
				break;
			}
		}
	}
}