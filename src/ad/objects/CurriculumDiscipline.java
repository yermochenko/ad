package ad.objects;

/*
* Дисциплина учебного плана
* */
public class CurriculumDiscipline {
	private Integer id;
	private Curriculum curriculum;
	private Discipline discipline;
	private Integer semester;

	public CurriculumDiscipline(Curriculum curriculum,Discipline discipline,Integer semester){
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
		this.curriculum=curriculum;
	}
	
	public Discipline getDiscipline(){
		return discipline;
	}
	public void setDiscipline(Discipline discipline){
		this.discipline=discipline;
	}
	
	public Integer getSemester(){
		return semester;
	}
	public void setSemester(Integer semester){
		this.semester=semester;
	}
}