package ad.objects.bean;

import ad.objects.Curriculum;
import ad.objects.CurriculumDiscipline;
import ad.objects.Discipline;

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