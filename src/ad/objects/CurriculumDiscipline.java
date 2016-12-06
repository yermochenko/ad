package ad.objects;

import ad.objects.bean.CurriculumImpl;
import ad.objects.bean.DisciplineImpl;

/**
 * Created by HomeInc on 06.12.2016.
 */
public interface CurriculumDiscipline extends Entity {
    CurriculumImpl getCurriculumImpl();
    void setCurriculumImpl(CurriculumImpl curriculumImpl);

    DisciplineImpl getDisciplineImpl();
    void setDisciplineImpl(DisciplineImpl disciplineImpl);

    Integer getSemester();
    void setSemester(Integer semester);
}
