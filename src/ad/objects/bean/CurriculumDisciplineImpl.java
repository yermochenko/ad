package ad.objects.bean;

import ad.objects.CurriculumDiscipline;

/*
* Дисциплина учебного плана
* */
public class CurriculumDisciplineImpl implements CurriculumDiscipline{
	private Integer id;
	private CurriculumImpl curriculumImpl;
	private DisciplineImpl disciplineImpl;
	private Integer semester;

	public CurriculumDisciplineImpl(CurriculumImpl curriculumImpl, DisciplineImpl disciplineImpl, Integer semester){
		this.curriculumImpl = curriculumImpl;
		this.disciplineImpl = disciplineImpl;
		this.semester = semester;
	}
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public CurriculumImpl getCurriculumImpl(){
		return curriculumImpl;
	}
	public void setCurriculumImpl(CurriculumImpl curriculumImpl){
		this.curriculumImpl = curriculumImpl;
	}
	
	public DisciplineImpl getDisciplineImpl(){
		return disciplineImpl;
	}
	public void setDisciplineImpl(DisciplineImpl disciplineImpl){
		this.disciplineImpl = disciplineImpl;
	}
	
	public Integer getSemester(){
		return semester;
	}
	public void setSemester(Integer semester){
		this.semester=semester;
	}
}