package ad.domain.bean;

import ad.domain.Curriculum;
import ad.domain.CurriculumDiscipline;
import ad.domain.Discipline;

/*
 * Дисциплина учебного плана
 */
public class CurriculumDisciplineImpl extends EntityImpl implements CurriculumDiscipline {
    private Curriculum curriculum;
    private Discipline discipline;
    private Integer semester;

    @Override
    public Curriculum getCurriculum() {
        return curriculum;
    }

    @Override
    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public Integer getSemester() {
        return semester;
    }

    @Override
    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
