package ad.domain;

public interface Specialty extends Entity {
    String getCode();
    void setCode(String code);
    String getShortName();
    void setShortName(String shortName);
    String getName();
    void setName(String name);
    String getSpecialtyDirection();
    void setSpecialtyDirection(String specialtyDirection);
    Specialty getParent();
    void setParent(Specialty parent);
    String getQualification();
    void setQualification(String qualification);
}
