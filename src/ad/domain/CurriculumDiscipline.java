package ad.domain;

public interface CurriculumDiscipline extends Entity {
    Curriculum getCurriculum();

    void setCurriculum(Curriculum curriculum);

    Discipline getDiscipline();

    void setDiscipline(Discipline discipline);

    Integer getSemester();

    void setSemester(Integer semester);
}
