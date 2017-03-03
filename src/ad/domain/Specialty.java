package ad.domain;

import java.util.List;

public interface Specialty extends Entity {
    String getCode();

    void setCode(String code);

    String getShortName();

    void setShortName(String shortName);

    String getName();

    void setName(String name);

    String getSpecialtyDirection();

    void setSpecialtyDirection(String specialtyDirection);

    String getQualification();

    void setQualification(String qualification);

    Specialty getParent();

    void setParent(Specialty parent);

    List<Specialty> getChildren();

    void setChildren(List<Specialty> children);
}
