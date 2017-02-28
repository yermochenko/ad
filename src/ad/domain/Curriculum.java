package ad.domain;

public interface Curriculum extends Entity {
    Integer getYear();
    void setYear(Integer year);
    Specialty getSpecialty();
    void setSpecialty(Specialty specialty);
}
