package ad.domain.bean;

import ad.domain.Curriculum;
import ad.domain.CurriculumDiscipline;
import ad.domain.Discipline;

/*
* Дисциплина учебного плана
* */
public class CurriculumDisciplineImpl implements CurriculumDiscipline{
	private Integer id;
	private Curriculum curriculum;
	private Discipline discipline;
	private Integer semester;

	public CurriculumDisciplineImpl(Curriculum curriculum, Discipline discipline, Integer semester){
		this.curriculum = curriculum;
		this.discipline = discipline;
		this.semester = semester;
	}
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public Curriculum getCurriculum(){
		return curriculum;
	}
	public void setCurriculum(Curriculum curriculum){
		this.curriculum = curriculum;
	}
	
	public Discipline getDiscipline(){
		return discipline;
	}
	public void setDiscipline(Discipline discipline){
		this.discipline = discipline;
	}
	
	public Integer getSemester(){
		return semester;
	}
	public void setSemester(Integer semester){
		this.semester=semester;
	}
}