package ad.domain.bean;

import java.util.List;

import ad.domain.Specialty;

/*
 * Специальность
 */
public class SpecialtyImpl extends EntityImpl implements Specialty {
    private String code;
    private String name;
    private String shortName;
    private String qualification;
    private String specialtyDirection;
    private Specialty parent;
    private List<Specialty> children;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String getQualification() {
        return qualification;
    }

    @Override
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String getSpecialtyDirection() {
        return specialtyDirection;
    }

    @Override
    public void setSpecialtyDirection(String specialtyDirection) {
        this.specialtyDirection = specialtyDirection;
    }

    @Override
    public Specialty getParent() {
        return parent;
    }

    @Override
    public void setParent(Specialty parent) {
        this.parent = parent;
    }

    @Override
    public List<Specialty> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<Specialty> children) {
        this.children = children;
    }
}
