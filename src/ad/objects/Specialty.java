package ad.objects;

import ad.objects.bean.SpecialtyImpl;

/**
 * Created by HomeInc on 06.12.2016.
 */
public interface Specialty extends Entity {
    String getCode();
    void setCode(String code);

    String getName();
    void setName(String name);

    String getShortName();
    void setShortName(String shortName);

    String getQualification();
    void setQualification(String qualification);

    String getSpecialtyDirection();
    void setSpecialtyDirection(String specialtyDirection);

    SpecialtyImpl getParent();
    void setParent(SpecialtyImpl parent);
}
