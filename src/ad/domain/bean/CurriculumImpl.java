package ad.domain.bean;

import java.util.List;

import ad.domain.Curriculum;
import ad.domain.CurriculumDiscipline;
import ad.domain.Specialty;

/*
 * Учебный план
 */
public class CurriculumImpl extends EntityImpl implements Curriculum {
    private Specialty specialty;
    private Integer year;
    private List<CurriculumDiscipline> curriculumDisciplines;

    @Override
    public Integer getYear() {
        return year;
    }

    @Override
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public Specialty getSpecialty() {
        return specialty;
    }

    @Override
    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public List<CurriculumDiscipline> getCurriculumDisciplines() {
        return curriculumDisciplines;
    }

    @Override
    public void setCurriculumDisciplines(List<CurriculumDiscipline> curriculumDisciplines) {
        this.curriculumDisciplines = curriculumDisciplines;
    }
}
