package ad.domain;

import java.util.List;

import ad.dao.exception.DaoException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "parent","entity" })
public interface Specialty extends Entity {
    String getCode();

    void setCode(String code);

    String getShortName();

    void setShortName(String shortName);

    String getName();

    void setName(String name);

    String getQualification();

    void setQualification(String qualification);

    Specialty getParent() throws DaoException;

    void setParent(Specialty parent);

    List<Specialty> getChildren() throws DaoException;

    void setChildren(List<Specialty> children);
}
