package ad.objects;

import ad.objects.bean.SpecialtyImpl;

/**
 * Created by HomeInc on 06.12.2016.
 */
public interface Curriculum extends Entity {
    Integer getYear();
    void setYear(Integer year);

    SpecialtyImpl getSpecialtyImpl();
    void setSpecialtyImpl(SpecialtyImpl specialtyImpl);
}
