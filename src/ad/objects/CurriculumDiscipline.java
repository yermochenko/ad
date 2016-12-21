package ad.objects;

/**
 * Created by HomeInc on 06.12.2016.
 */
public interface CurriculumDiscipline extends Entity {
    Curriculum getCurriculum();
    void setCurriculum(Curriculum curriculum);

    Discipline getDiscipline();
    void setDiscipline(Discipline discipline);

    Integer getSemester();
    void setSemester(Integer semester);
}
