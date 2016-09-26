package ad;

public class CurriculumDiscipline {
	private Integer Id;
	private Curriculum Curriculum;
	private Discipline Discipline;
	private Integer Semester;
	
	public Integer getId(){
		return Id;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	
	public Curriculum getCurriculum(){
		return Curriculum;
	}
	public void setCurriculum(Curriculum Curriculum){
		this.Curriculum=Curriculum;
	}
	
	public Discipline getDiscipline(){
		return Discipline;
	}
	public void setDiscipline(Discipline Discipline){
		this.Discipline=Discipline;
	}
	
	public Integer getSemester(){
		return Semester;
	}
	public void setSemester(Integer Semester){
		this.Semester=Semester;
	}
}