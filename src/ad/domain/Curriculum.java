package ad.domain;

/**
 * Created by HomeInc on 06.12.2016.
 */
public interface Curriculum extends Entity {
    Integer getYear();
    void setYear(Integer year);

    Specialty getSpecialty();
    void setSpecialty(Specialty specialty);
}
