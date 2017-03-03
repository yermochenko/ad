package ad.domain;

import java.util.List;

public interface Curriculum extends Entity {
    Integer getYear();

    void setYear(Integer year);

    Specialty getSpecialty();

    void setSpecialty(Specialty specialty);

    List<CurriculumDiscipline> getCurriculumDisciplines();

    void setCurriculumDisciplines(List<CurriculumDiscipline> curriculumDisciplines);
}
